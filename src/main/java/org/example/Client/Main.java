package org.example.Client;

import org.example.Client.utils.ClientSocket;
import org.example.Client.utils.User;
import org.example.Models.MessageHandler;

public class Main {
    public static void main(String[] args){
        Factory.createClient().Start();
    }
}
