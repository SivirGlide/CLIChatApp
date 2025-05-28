package org.example.Client;

import org.example.Client.interfaces.MessageInterface;
import org.example.Client.interfaces.SocketInterface;
import org.example.Client.interfaces.UserInterface;
import org.example.Client.utils.ClientSocket;
import org.example.Client.utils.User;
import org.example.Models.MessageHandler;

public class Factory {

    public static ClientManager createClient(){
        UserInterface user = new User();
        SocketInterface socket = new ClientSocket();
        MessageInterface messageHandler = new MessageHandler(socket.getSocket());

        return new ClientManager(socket,user,messageHandler);
    }
}
