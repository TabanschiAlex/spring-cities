package com.example.springfirstapp.controller;

import com.example.springfirstapp.service.CityService;
import org.hibernate.mapping.Any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/city")
public class CityController {
  @Autowired
  private CityService cityService;

  @GetMapping
  public ResponseEntity<?> index() {
    try {
      return ResponseEntity.ok(cityService.getCities());
    } catch (Exception e) {
      return ResponseEntity.unprocessableEntity().body("Error");
    }
  }
}
