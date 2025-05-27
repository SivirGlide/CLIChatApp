package org.example.Models;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Message implements Runnable{
    private Socket socket;
    private String message;

    public Message (String message, Socket socket){
        this.socket = socket;
        this.message = message;
    }
    @Override
    public void run() {
        try {
           PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
           writer.println(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
