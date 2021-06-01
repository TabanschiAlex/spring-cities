package com.example.springfirstapp.controller;

import com.example.springfirstapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
  @Autowired
  private UserService userService;

  @GetMapping()
  public ResponseEntity getAllUsers() {
    try {
      return ResponseEntity.ok("A");
    } catch (Exception e) {
      return ResponseEntity.badRequest().body("Error");
    }
  }
}
