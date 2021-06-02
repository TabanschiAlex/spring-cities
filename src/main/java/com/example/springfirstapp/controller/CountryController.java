package com.example.springfirstapp.controller;

import com.example.springfirstapp.entity.Country;
import com.example.springfirstapp.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/countries")
public class CountryController {
  @Autowired
  private CountryService countryService;

  @GetMapping
  public ResponseEntity<?> getCountries(@RequestParam Integer page, String sort) {
    try {
      return ResponseEntity.ok(countryService.getCountries(page, sort));
    } catch (Exception e) {
      return ResponseEntity.unprocessableEntity().body("Error");
    }
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getCountryById(@PathVariable Integer id) {
    try {
      return ResponseEntity.ok(countryService.getCountryById(id));
    } catch (Exception e) {
      return ResponseEntity.unprocessableEntity().body(e.getMessage());
    }
  }

  @PostMapping
  public ResponseEntity<?> addCountry(@RequestBody Country country) {
    try {
      return ResponseEntity.ok(countryService.addCountry(country));
    } catch (Exception e) {
      return ResponseEntity.unprocessableEntity().body(e.getMessage());
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

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteCountry(@PathVariable Integer id) {
    try {
      countryService.deleteCountry(id);
      return ResponseEntity.ok("Successfully deleted");
    } catch (Exception e) {
      return ResponseEntity.unprocessableEntity().body(e.getMessage());
    }
  }
}
