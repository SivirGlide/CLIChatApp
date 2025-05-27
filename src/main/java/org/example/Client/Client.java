package org.example.Client;

import org.example.Models.Message;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public void Start() {
        System.out.println("Attempting to contact server...");
        try (Socket socket = new Socket("localhost", 8080)) {
            System.out.println("Connection successful");
            String message;

            User user = new User();
            new Thread(new Message(user.getUsername(), socket)).start();

            new Thread(() -> {
                try {
                    BufferedReader clientInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    String serverMessage;
                    while ((serverMessage = clientInput.readLine()) != null) {
                        System.out.println(serverMessage);
                    }
                } catch (IOException e) {
                    System.out.println("Server connection lost, attempting to reconnect...");
                    //as the message says.
                }
            }).start();
            while (true){
                Scanner inputScanner = new Scanner(System.in);
                message = inputScanner.nextLine();
                new Thread(new Message(message,socket)).start();
            }
        } catch (IOException e) {
            System.out.println("Failed to contact server Please check socket connection details are correct and server is on");
            //here is where i can rerun the program to retry connecting to the server
        }
    }

    public static void main(String[] args){
        Client client = new Client();
        client.Start();
    }
}
