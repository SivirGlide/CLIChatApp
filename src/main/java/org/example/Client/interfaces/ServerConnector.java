package org.example.Client.interfaces;

import java.net.Socket;

public interface ServerConnector {

    ///establish connection to the socket and return it upon success
    Socket connect();

    ///listen for incoming server messages
    void MaintainServerConnection();

    String UserInput();
}
