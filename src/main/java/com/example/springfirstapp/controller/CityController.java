package com.example.springfirstapp.controller;

import com.example.springfirstapp.entity.City;
import com.example.springfirstapp.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/city")
public class CityController {
  @Autowired
  private CityService cityService;

  @GetMapping
  public ResponseEntity<?> getCountries() {
    try {
      return ResponseEntity.ok(cityService.getCities());
    } catch (Exception e) {
      return ResponseEntity.unprocessableEntity().body("Error");
    }
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getCityById(@PathVariable Integer id) {
    try {
      return ResponseEntity.ok(cityService.getCityById(id));
    } catch (Exception e) {
      return ResponseEntity.unprocessableEntity().body(e.getMessage());
    }
  }

  @PostMapping
  public ResponseEntity<?> addCity(@RequestBody City city) {
    try {
      return ResponseEntity.ok(cityService.addCity(city));
    } catch (Exception e) {
      return ResponseEntity.unprocessableEntity().body(e.getMessage());
    }
  }

  @PutMapping
  public ResponseEntity<?> updateCity(@RequestBody City city) {
    try {
      return ResponseEntity.ok(cityService.updateCity(city));
    } catch (Exception e) {
      return ResponseEntity.unprocessableEntity().body(e.getMessage());
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteCity(@PathVariable Integer id) {
    try {
      cityService.deleteCountry(id);
      return ResponseEntity.ok("Successfully deleted");
    } catch (Exception e) {
      return ResponseEntity.unprocessableEntity().body(e.getMessage());
    }
  }
}
