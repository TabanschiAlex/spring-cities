package com.example.springfirstapp.service;

import com.example.springfirstapp.entity.Country;
import com.example.springfirstapp.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService {
  @Autowired
  public CountryRepository countryRepository;

  public Iterable<Country> getCountries() {
    return countryRepository.findAll();
  }

  public Country addCountry(Country country) {
    return countryRepository.save(country);
  }

  public Country updateCountry(Country country) {
    Country data = countryRepository.findById(country.getId()).get();
    System.out.println(data);
    data.setName(country.getName());
    data.setCode(country.getCode());
    countryRepository.save(data);
    return countryRepository.save(country);
  }
}
