package org.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    ArrayList<ClientHandler> clientList = new ArrayList<>();
    public void Start(final int port) {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
        while (true){
                Socket socket = serverSocket.accept();
                ClientHandler clientHandler = new ClientHandler(socket, this);
                clientList.add(clientHandler);
                Thread thread = new Thread(clientHandler);
                thread.start();

        }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
    }

    public void broadcastMessage(String message, ClientHandler sender){
        for (ClientHandler client : clientList) {
            if (client != sender) {client.sendMessage(message);}
        }
    }
}
