package com.example.springfirstapp.controller;

import com.example.springfirstapp.entity.Country;
import com.example.springfirstapp.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/country")
public class CountryController {
  @Autowired
  private CountryService countryService;

  @GetMapping
  public ResponseEntity<?> index() {
    try {
      System.out.println(countryService.getCountries());
      return ResponseEntity.ok(countryService.getCountries());
    } catch (Exception e) {
      return ResponseEntity.unprocessableEntity().body("Error");
    }
  }

  @PostMapping
  public ResponseEntity<?> addCountry(@RequestBody Country country) {
    try {
      return ResponseEntity.ok(countryService.addCountry(country));
    } catch (Exception e) {
      return ResponseEntity.unprocessableEntity().body("Error");
    }
  }

  @PutMapping
  public ResponseEntity<?> updateCountry(@RequestBody Country country) {
    try {
      return ResponseEntity.ok(countryService.updateCountry(country));
    } catch (Exception e) {
      return ResponseEntity.unprocessableEntity().body(e.getMessage());
    }
  }

}
