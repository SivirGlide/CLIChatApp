package org.example.Client;

import org.example.Server.Server;

public class Job implements Runnable{
    Server server;
    public Job(Server server){
        this.server = server;
    }
    @Override
    public void run() {
        System.out.println("I am a Job!");
    }
}
