package com.example.springfirstapp.exception.user;

public class UserAlreadyExistsException extends Exception {
    public UserAlreadyExistsException() {
        super("User already exists!");
    }
}
