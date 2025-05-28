package org.example.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Server {
    ArrayList<ClientHandler> clientList = new ArrayList<>();
    Queue<Runnable> dispatchQueue = new ConcurrentLinkedQueue<>();
    public void Start(final int port) {
        new Thread(() -> connectClients(port)).start();

        new Thread(() -> {
            while (true){
                try{
                    Runnable jobToExecute = dispatchQueue.remove();
                    new Thread(jobToExecute).start();
                } catch (Exception ignored) {
                }
            }
        }).start();
    }

    public void broadcastMessage(String message, ClientHandler sender){
        for (ClientHandler client : clientList) {
            if (client != sender) {client.sendMessage(message);}
        }
    }

    private void connectClients(int port){
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

}
