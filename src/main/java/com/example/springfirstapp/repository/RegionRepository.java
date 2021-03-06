package com.example.springfirstapp.repository;

import com.example.springfirstapp.entity.Country;
import com.example.springfirstapp.entity.Region;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Collection;
import java.util.List;

public interface RegionRepository extends PagingAndSortingRepository<Region, Integer> {
    Region findByName(String regionName);

    List<Region> findAllByIdIsIn(Collection<Integer> id);

    Page<Region> findAllByCountryAndNameIsIn(Country country, Pageable pageable, Collection<String> name);

    Page<Region> findAllByCountry(Country country, Pageable pageable);
}
