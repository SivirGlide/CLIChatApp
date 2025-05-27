package org.example.Server;

import org.example.Client.Job;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    ArrayList<ClientHandler> clientList = new ArrayList<>();
    ArrayList<Runnable> dispatchQueue = new ArrayList<>();
    public void Start(final int port) {
        new Thread(() -> connectClients(port)).start();

        new Thread(() -> {
            while (true){
                try{
                    Runnable jobToExecute = dispatchQueue.get(0);
                    jobToExecute.run();
                    dispatchQueue.remove(0);
                } catch (Exception ignored) {
                }
            }
        }).start();
    }

    public void broadcastMessage(String message, ClientHandler sender){
        for (ClientHandler client : clientList) {
            if (client != sender) {client.sendMessage(message);}
        }
        dispatchQueue.add(new Job(this));
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
