package com.example.springfirstapp.repository;

import com.example.springfirstapp.entity.Region;
import org.springframework.data.repository.CrudRepository;

public interface RegionRepository extends CrudRepository<Region, Integer> {
}
