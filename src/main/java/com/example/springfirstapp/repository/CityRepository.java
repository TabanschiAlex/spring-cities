package com.example.springfirstapp.repository;

import com.example.springfirstapp.entity.City;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CityRepository extends PagingAndSortingRepository<City, Integer> {
}
