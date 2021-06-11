package com.example.springfirstapp.dataseed;

import com.example.springfirstapp.dto.AuthorizationDto;
import com.example.springfirstapp.repository.UserRepository;
import com.example.springfirstapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserDataLoader implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) {
        loadUserData();
    }

    private void loadUserData() {
        if (userRepository.count() == 0) {
            AuthorizationDto user1 = new AuthorizationDto("test@test.com", "123");
            AuthorizationDto user2 = new AuthorizationDto("admin", "123");

            userService.register(user1);
            userService.register(user2);
        }
        System.out.println(userRepository.count());
    }
}
