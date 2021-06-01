package com.example.springfirstapp.controller;

import com.example.springfirstapp.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/region")
public class RegionController {
  @Autowired
  private RegionService regionService;

  @GetMapping
  public ResponseEntity index() {
    try {
      return ResponseEntity.ok("A");
    } catch (Exception e) {
      return ResponseEntity.badRequest().body("Error");
    }
  }
}
