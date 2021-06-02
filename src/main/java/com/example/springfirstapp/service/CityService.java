package com.example.springfirstapp.service;

import com.example.springfirstapp.entity.City;
import com.example.springfirstapp.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {
  @Autowired
  private CityRepository cityRepository;

  public List<City> getCities(Integer page, String sort) {
    Pageable pageable = PageRequest.of(page, 10, Sort.by(sort));
    return cityRepository.findAll(pageable).toList();
  }

  public Optional<City> getCityById(Integer id) {
    return cityRepository.findById(id);
  }

  public City addCity(City city) {
    return cityRepository.save(city);
  }

  public City updateCity(City city) {
    City data = cityRepository.findById(city.getId()).get();
    data.setName(city.getName());
    data.setRegion(city.getRegion());
    cityRepository.save(data);
    return cityRepository.save(city);
  }

  public void deleteCountry(Integer id) {
    cityRepository.deleteById(id);
  }
}
