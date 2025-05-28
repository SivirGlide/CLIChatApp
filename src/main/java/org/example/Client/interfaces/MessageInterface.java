package org.example.Client.interfaces;

public interface MessageInterface extends Runnable{

    void setMessage(String message);

    void setEvent(String event);

    @Override
    void run();
}
