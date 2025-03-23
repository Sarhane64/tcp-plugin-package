package com.sealocker.plugins.tcp;

import android.util.Log;
import java.io.OutputStream;
import java.io.InputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import com.getcapacitor.*;

@CapacitorPlugin(name = "TcpSocketPlugin")
public class TcpSocketPluginPlugin extends Plugin {

    private TcpSocketPlugin implementation = new TcpSocketPlugin();
    private Socket socket = null;
    private OutputStream outputStream = null;
    private InputStream inputStream = null;

    @PluginMethod
    public void connect(PluginCall call) {
        String host = call.getString("host");
        Integer port = call.getInt("port");

        try {
            socket = new Socket(host, port);
            outputStream = socket.getOutputStream();
            call.resolve();
        } catch (Exception e) {
            call.reject("Failed to connect", e);
        }
    }

    @PluginMethod
    public void send(PluginCall call) {
        String message = call.getString("message");

        try {
            if (outputStream != null && inputStream != null) {
                outputStream.write(message.getBytes(StandardCharsets.UTF_8));
                outputStream.flush();

                listen(call);

                call.resolve();
            } else {
                call.reject("OutputStream or InputStream is null");
            }
        } catch (Exception e) {
            call.reject("Failed to send message", e);
        }
    }

    @PluginMethod
    public void listen(PluginCall call) {
        if (inputStream == null) {
            call.reject("Socket is not connected");
            return;
        }

        new Thread(() -> {
            try {
                byte[] buffer = new byte[1024];
                int bytesRead;

                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    String receivedMessage = new String(buffer, 0, bytesRead, StandardCharsets.UTF_8);

                    JSObject ret = new JSObject();
                    ret.put("message", receivedMessage);

                    notifyListeners("dataReceived", ret);
                }
            } catch (Exception e) {
                Log.e("TcpSocketPlugin", "Error while listening", e);
            }
        }).start();
    }

    @PluginMethod
    public void close(PluginCall call) {
        try {
            if (socket != null) {
                socket.close();
            }
            call.resolve();
        } catch (Exception e) {
            call.reject("Failed to close socket", e);
        }
    }

}
