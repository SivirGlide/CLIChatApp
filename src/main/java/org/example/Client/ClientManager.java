package org.example.Client;

import org.example.Client.interfaces.ServerConnector;
import org.example.Client.utils.ClientSocket;
import org.example.Client.utils.ExecutionService;
import org.example.Client.utils.User;
import org.example.Models.MessageHandler;

public class ClientManager {
    /// Responsible for managing the client socket
    ServerConnector socket;
    /// Handles The user details
    User user;
    /// Handles message structure
    MessageHandler messageHandler;

    public ClientManager(ServerConnector socket, User user, MessageHandler messageHandler) {
        this.socket = socket;
        this.user = user;
        this.messageHandler = messageHandler;
    }

    public void Start() {
            SendInitalMessage();
            while (true){
                String message = socket.UserInput();
                messageHandler.setMessage(message);
                ExecutionService.execute(messageHandler);
            }
    }

    public void SendInitalMessage(){
        messageHandler.setMessage(user.getUsername());
        ExecutionService.execute(messageHandler);
    }

}
