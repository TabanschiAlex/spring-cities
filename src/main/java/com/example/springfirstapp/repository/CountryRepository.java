package com.example.springfirstapp.repository;

import com.example.springfirstapp.entity.Country;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CountryRepository extends CrudRepository<Country, Integer> {
}
