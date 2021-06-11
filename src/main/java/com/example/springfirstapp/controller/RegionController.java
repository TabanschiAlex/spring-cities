package com.example.springfirstapp.controller;

import com.example.springfirstapp.entity.Region;
import com.example.springfirstapp.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/regions")
public class RegionController {
  @Autowired
  private RegionService regionService;

  @GetMapping
  public ResponseEntity<?> getRegions(@RequestParam Integer page, String sort) {
    try {
      return ResponseEntity.ok(regionService.getRegions(page, sort));
    } catch (Exception e) {
      return ResponseEntity.unprocessableEntity().body("Error");
    }
  }

  @GetMapping("/countries")
  public ResponseEntity<?> getRegionsByCountry(
          @RequestParam
                  Integer page,
                  String sort,
                  String countryName,
                  Optional<List<String>> name
  ) {
    try {
      return ResponseEntity.ok(regionService.getRegionsByCountry(page, sort, countryName, name));
    } catch (Exception e) {
      return ResponseEntity.unprocessableEntity().body(e.getMessage());
    }
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getRegionById(@PathVariable Integer id) {
    try {
      return ResponseEntity.ok(regionService.getRegionById(id));
    } catch (Exception e) {
      return ResponseEntity.unprocessableEntity().body(e.getMessage());
    }
  }

  @PostMapping
  public ResponseEntity<?> addRegion(@RequestBody Region region) {
    try {
      return ResponseEntity.ok(regionService.addRegion(region));
    } catch (Exception e) {
      return ResponseEntity.unprocessableEntity().body(e.getMessage());
    }
  }

  @PutMapping
  public ResponseEntity<?> updateRegion(@RequestBody Region region) {
    try {
      return ResponseEntity.ok(regionService.updateRegion(region));
    } catch (Exception e) {
      return ResponseEntity.unprocessableEntity().body(e.getMessage());
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteRegion(@PathVariable Integer id) {
    try {
      regionService.deleteRegion(id);
      return ResponseEntity.ok("Successfully deleted");
    } catch (Exception e) {
      return ResponseEntity.unprocessableEntity().body(e.getMessage());
    }
  }
}
