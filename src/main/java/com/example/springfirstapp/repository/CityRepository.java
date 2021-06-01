package com.example.springfirstapp.repository;

import com.example.springfirstapp.entity.City;
import org.springframework.data.repository.CrudRepository;

public interface CityRepository extends CrudRepository<City, Integer> {
}
