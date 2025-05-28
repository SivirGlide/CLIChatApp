package org.example.Client.utils;

import java.util.Scanner;

public class User {

    String username;
    String password;
    Boolean valid = true;
    public User(){
        System.out.print("Signup or Login: ");
        while (valid){
            String response = new Scanner(System.in).nextLine();
            switch (response.toLowerCase()){
                case ("signup"):
                    valid = false;
                    signUp();
                    break;
                case ("login"):
                    valid = false;
                    signIn();
                    break;
                default:
                    System.out.println("Input not recognised. Please enter signup or login.");
            }
        }
    }

    private void signUp(){
        System.out.print("Enter a username: ");
        username = new Scanner(System.in).nextLine();
        System.out.print("Enter a password: ");
        password = new Scanner(System.in).nextLine();
        System.out.println("User details successfully captured");
        // details should be put into a table model and sent off to database for persistence
    }

    private void signIn(){
    }

    public String getUsername() {
        return username;
    }
}
