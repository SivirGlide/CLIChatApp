package org.example.Client;

import org.example.Client.interfaces.MessageInterface;
import org.example.Client.interfaces.SocketInterface;
import org.example.Client.interfaces.UserInterface;
import org.example.Client.utils.ExecutionService;
import org.example.Client.utils.User;

public class ClientManager {
    /// Responsible for managing the client socket
    SocketInterface socket;
    /// Handles The user details
    UserInterface user;
    /// Handles message structure
    MessageInterface messageHandler;

    public ClientManager(SocketInterface socket, UserInterface user, MessageInterface messageHandler) {
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
