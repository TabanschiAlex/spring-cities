package com.example.springfirstapp.service;

import com.example.springfirstapp.entity.City;
import com.example.springfirstapp.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {
  @Autowired
  private CityRepository cityRepository;

  public Iterable<City> getCities() {
    return cityRepository.findAll();
  }

  public City addCity(City city) {
    return cityRepository.save(city);
  }

  public void updateCity() {

  }
}
