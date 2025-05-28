package org.example.Client;

import org.example.Client.utils.User;

import java.util.Scanner;

public class Landing {
    User user;
    //navigate between 1. join chatroom, 2. direct messages, 3. add friend, 4. view friend requests
    public Landing(User user){
        this.user = user;
        String formatted = String.format("Welcome %s! Enter a number" +
                "\n1.Join Chatroom" +
                "\n2.Direct Messages" +
                "\n3.Add Friend" +
                "\n4.Friend Requests", user.getUsername());
        System.out.println(formatted);

        String intScanner = new Scanner(System.in).nextLine();

        switch(intScanner){
            case ("1"):
                chatRoom();
                break;
            case ("2"):
                directMessage();
                break;
            case ("3"):
                addFriend();
                break;
            case ("4"):
                friendRequests();
                break;
            default:
                System.out.print("Number not recognised, please enter a valid number: ");
        }
    }

    private void chatRoom(){
        System.out.print("Enter the chat name of the chat you would like to join: ");
        String connectionRequest = new Scanner(System.in).nextLine();
    }

    private void directMessage(){
        System.out.print("Enter the username of the user you would like to message: ");
        String connectionRequest = new Scanner(System.in).nextLine();
    }

    private void addFriend(){

    }

    private void friendRequests(){

    }
}
