package com.sealocker.plugins.tcp;

import android.util.Log;
import java.io.OutputStream;
import java.io.InputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class TcpSocketPlugin {
    private Socket socket = null;
    private OutputStream outputStream = null;
    private InputStream inputStream = null;
    private TcpSocketListener listener;

    // Interface pour écouter les messages reçus
    public interface TcpSocketListener {
        void onMessageReceived(String message);
    }

    // Constructeur avec listener
    public TcpSocketPlugin(TcpSocketListener listener) {
        this.listener = listener;
    }

    // Méthode pour établir la connexion
    public void connect(String host, int port) throws Exception {
        socket = new Socket(host, port);
        outputStream = socket.getOutputStream();
        inputStream = socket.getInputStream();
        startListening();
    }

    // Méthode pour envoyer un message
    public void send(String message) throws Exception {
        if (outputStream != null) {
            outputStream.write(message.getBytes(StandardCharsets.UTF_8));
            outputStream.flush();
        }
    }

    // Méthode pour fermer la connexion
    public void close() throws Exception {
        if (socket != null) {
            socket.close();
        }
    }

    // Méthode pour écouter les messages du serveur
    private void startListening() {
        new Thread(() -> {
            try {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while (socket != null && !socket.isClosed() && (bytesRead = inputStream.read(buffer)) != -1) {
                    String receivedMessage = new String(buffer, 0, bytesRead, StandardCharsets.UTF_8);
                    Log.i("TcpSocketPlugin", "Message reçu: " + receivedMessage);

                    if (listener != null) {
                        listener.onMessageReceived(receivedMessage);
                    }
                }
            } catch (Exception e) {
                Log.e("TcpSocketPlugin", "Erreur lors de l'écoute", e);
            }
        }).start();
    }
}
