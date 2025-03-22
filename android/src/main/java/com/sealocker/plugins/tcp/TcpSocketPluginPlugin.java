package com.sealocker.plugins.tcp;

import android.util.Log;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import com.getcapacitor.*;

@CapacitorPlugin(name = "TcpSocketPlugin")
public class TcpSocketPluginPlugin extends Plugin {

    private TcpSocketPlugin implementation = new TcpSocketPlugin();
    private Socket socket = null;
    private OutputStream outputStream = null;

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
            if (outputStream != null) {
                outputStream.write(message.getBytes(StandardCharsets.UTF_8));
                outputStream.flush();
            }
            call.resolve();
        } catch (Exception e) {
            call.reject("Failed to send message", e);
        }
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
