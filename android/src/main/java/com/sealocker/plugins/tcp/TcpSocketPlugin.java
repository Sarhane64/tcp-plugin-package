package com.sealocker.plugins.tcp;

import android.util.Log;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class TcpSocketPlugin {
    private Socket socket = null;
    private OutputStream outputStream = null;

    public void connect(String host, int port) throws Exception {
        socket = new Socket(host, port);
        outputStream = socket.getOutputStream();
    }

    public void send(String message) throws Exception {
        if (outputStream != null) {
            outputStream.write(message.getBytes(StandardCharsets.UTF_8));
            outputStream.flush();
        }
    }

    public void close() throws Exception {
        if (socket != null) {
            socket.close();
        }
    }

    public String echo(String value) {
        Log.i("Echo", value);
        return value;
    }
}