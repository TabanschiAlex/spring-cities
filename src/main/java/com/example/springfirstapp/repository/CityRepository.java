package com.example.springfirstapp.repository;

import com.example.springfirstapp.entity.City;
import com.example.springfirstapp.entity.Region;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Collection;

public interface CityRepository extends PagingAndSortingRepository<City, Integer> {
    Page<City> findAllByRegionIsIn(Collection<Region> regions, Pageable pageable);

    Page<City> findAllByRegionIsInAndNameIsIn(Collection<Region> regions, Pageable pageable, Collection<String> name);
}
