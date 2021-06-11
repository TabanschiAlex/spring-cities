package com.example.springfirstapp.repository;

import com.example.springfirstapp.entity.Country;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CountryRepository extends PagingAndSortingRepository<Country, Integer> {
    Country findByName(String name);
}
