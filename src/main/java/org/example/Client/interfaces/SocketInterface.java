package org.example.Client.interfaces;

import java.net.Socket;

public interface SocketInterface {

    ///establish connection to the socket and return it upon success
    Socket connect();

    ///listen for incoming server messages
    void MaintainServerConnection();

    ///get user input
    String UserInput();

    Socket getSocket();
}
