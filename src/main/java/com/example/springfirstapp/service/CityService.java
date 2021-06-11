package com.example.springfirstapp.service;

import com.example.springfirstapp.entity.City;
import com.example.springfirstapp.entity.Region;
import com.example.springfirstapp.repository.CityRepository;
import com.example.springfirstapp.repository.RegionRepository;
import org.hibernate.Session;
import org.jetbrains.annotations.NotNull;
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

  @Autowired
  private RegionRepository regionRepository;

  public List<City> getCities(Integer page, String sort) {
    Pageable pageable = PageRequest.of(page, 10, Sort.by(sort));
    return cityRepository.findAll(pageable).toList();
  }

  public List<City> getCitiesByRegion(Integer page, String sort, String regionName, Optional<List<String>> name) {
    Pageable pageable = PageRequest.of(page, 10, Sort.by(sort));
    Region region = regionRepository.findByName(regionName);

    if (name.isPresent()) {
      return cityRepository.findAllByRegionAndNameIsIn(region, pageable, name.get()).toList();
    }

    return cityRepository.findAllByRegion(region, pageable).toList();
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

    return cityRepository.save(data);
  }

  public void deleteCountry(Integer id) {
    cityRepository.deleteById(id);
  }
}
