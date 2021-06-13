package com.example.springfirstapp.exception.user;

public class UserNotFoundException extends Exception {
    public UserNotFoundException() {
        super("User not found!");
    }
}
