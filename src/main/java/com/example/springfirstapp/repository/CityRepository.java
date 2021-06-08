package com.example.springfirstapp.repository;

import com.example.springfirstapp.entity.City;
import com.example.springfirstapp.entity.Region;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CityRepository extends PagingAndSortingRepository<City, Integer> {
  Page<City> findAllByRegion(Region region, Pageable pageable);
}
