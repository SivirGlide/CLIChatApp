package org.example.Client;

import org.example.Client.utils.ClientSocket;
import org.example.Client.utils.User;
import org.example.Models.MessageHandler;

public class Factory {

    public static ClientManager createClient(){
        User user = new User();
        ClientSocket socket = new ClientSocket();
        MessageHandler messageHandler = new MessageHandler(socket.getSocket());

        return new ClientManager(socket,user,messageHandler);
    }
}
