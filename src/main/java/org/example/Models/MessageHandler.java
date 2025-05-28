package org.example.Models;

import org.example.Client.interfaces.MessageInterface;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class MessageHandler implements MessageInterface {
    private final Socket socket;
    private String message;


    public MessageHandler(Socket socket){
        this.socket = socket;
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

    @Override
    public void setMessage(String newMessage){
        message = newMessage;
    }

    @Override
    public void setEvent(String event) {

    }

}
