package org.example.Client.utils;

import org.example.Client.interfaces.SocketInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class ClientSocket implements SocketInterface, Runnable {
    Socket socket;

    public ClientSocket(){
        this.socket = connect();
        ExecutionService.execute(this);
    }

    public Socket connect() {
        System.out.println("Attempting to contact server...");
        while(true) {
            try {
                Socket socket = new Socket("localhost", 8080);
                System.out.println("Connection successful");
                return socket;

            } catch (IOException e) {
                System.out.println("Failed to contact server Please check socket connection details are correct and server is on");
            }
            System.out.println("Failed to contact server, Attempting reconnect");
        }
    }

    public void MaintainServerConnection() {
            try {
                BufferedReader clientInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String serverMessage;
                while ((serverMessage = clientInput.readLine()) != null) {
                    System.out.println(serverMessage);
                }
            } catch (IOException e) {
                System.out.println(e);
            }
    }

    public String UserInput(){
            return new Scanner(System.in).nextLine();
    }

    public void SendMessage(String message){

    }

    public Socket getSocket() {
        return socket;
    }

    @Override
    public void run() {
        MaintainServerConnection();
    }
}
