package com.example.springfirstapp.service;

import com.example.springfirstapp.entity.User;
import com.example.springfirstapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    public UserRepository userRepository;

    public User getAllUsers() {
        return (User) userRepository.findAll();
    }
}
