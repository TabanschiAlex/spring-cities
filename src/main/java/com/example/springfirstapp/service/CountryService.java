package com.example.springfirstapp.service;

import com.example.springfirstapp.entity.Country;
import com.example.springfirstapp.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {
    @Autowired
    public CountryRepository countryRepository;

    public List<Country> getCountries(Integer page, String sort) {
        Pageable pageable = PageRequest.of(page, 10, Sort.by(sort));
        return countryRepository.findAll(pageable).toList();
    }

    public Optional<Country> getCountryById(Integer id) {
        return countryRepository.findById(id);
    }

    public Country addCountry(Country country) {
        return countryRepository.save(country);
    }

    public Country updateCountry(Country country) {
        Country data = countryRepository.findById(country.getId()).get();
        data.setName(country.getName());
        data.setCode(country.getCode());
        countryRepository.save(data);

        return countryRepository.save(country);
    }

    public void deleteCountry(Integer id) {
        countryRepository.deleteById(id);
    }
}
