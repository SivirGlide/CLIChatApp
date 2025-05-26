package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientHandler implements Runnable{
    Socket client;
    String username;
    Server server;
    String message;
    public ClientHandler(Socket socket, Server server){
        this.client = socket;
        this.server = server;
    }

    private void sustainConnection(){
        try {
            BufferedReader clientInput = new BufferedReader(new InputStreamReader(client.getInputStream()));
            while ((message = clientInput.readLine()) != null) {
                System.out.println(username + " : " + message);
                message = username + ": " + message;
                server.broadcastMessage(message, this);
            }
            System.out.println(username + " disconnected...");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        try {
            BufferedReader initalMessage = new BufferedReader(new InputStreamReader(client.getInputStream()));
            while ((username = initalMessage.readLine()) != null) {
                System.out.println("Connection coming from ip address: " + client.getInetAddress().getHostAddress() + " Welcome " + username + "!");
                break;
            }
            sustainConnection();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendMessage(String message){
        new Thread(new Message(message,client)).start();
    }
}
