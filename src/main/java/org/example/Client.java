package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public void Start() {
        try (Socket socket = new Socket("localhost", 8080)) {
            String message;
            String username;

            //username configuration
            System.out.println("What is your name?: ");
            Scanner usernameScanner = new Scanner(System.in);
            username = usernameScanner.nextLine();
            new Thread(new Message(username,socket)).start();

            new Thread(() -> {
                try {
                    BufferedReader clientInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    String serverMessage;
                    while ((serverMessage = clientInput.readLine()) != null) {
                        System.out.println(serverMessage);
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }).start();
            while (true){
                Scanner inputScanner = new Scanner(System.in);
                message = inputScanner.nextLine();
                new Thread(new Message(message,socket)).start();
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    public static void main(String[] args){
        Client client = new Client();
        client.Start();
    }
}
