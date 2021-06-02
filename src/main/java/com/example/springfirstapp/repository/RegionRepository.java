package com.example.springfirstapp.repository;

import com.example.springfirstapp.entity.Region;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RegionRepository extends PagingAndSortingRepository<Region, Integer> {
}
