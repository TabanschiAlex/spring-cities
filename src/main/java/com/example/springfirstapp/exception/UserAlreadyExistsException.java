package com.example.springfirstapp.exception;

public class UserAlreadyExistsException extends Exception {
    public UserAlreadyExistsException() {
        super("User already exists!");
    }
}
