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

    // Méthode pour établir la connexion
    public void connect(String host, int port) throws Exception {
        socket = new Socket(host, port);
        outputStream = socket.getOutputStream();
        inputStream = socket.getInputStream();
    }

    // Méthode pour envoyer un message et écouter la réponse
    public void send(String message) throws Exception {
        if (outputStream != null) {
            // Envoi du message
            outputStream.write(message.getBytes(StandardCharsets.UTF_8));
            outputStream.flush();
        }

        // Écoute de la réponse
        listen();
    }

    // Méthode pour fermer la connexion
    public void close() throws Exception {
        if (socket != null) {
            socket.close();
        }
    }

    // Méthode d'écoute qui lit la réponse du serveur
    public void listen() {
        if (inputStream != null) {
            byte[] buffer = new byte[1024];
            try {
                int bytesRead;
                // Lecture des données du serveur
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    String receivedMessage = new String(buffer, 0, bytesRead, StandardCharsets.UTF_8);
                    Log.i("TcpSocketPlugin", "Message reçu : " + receivedMessage);

                    // Tu peux ajouter ici une logique pour gérer la réponse ou la renvoyer
                    // comme une notification, un callback ou autre.
                }
            } catch (Exception e) {
                Log.e("TcpSocketPlugin", "Erreur lors de l'écoute", e);
            }
        }
    }

    // Méthode d'écho pour tester la connexion
    public String echo(String value) {
        Log.i("Echo", value);
        return value;
    }
}
