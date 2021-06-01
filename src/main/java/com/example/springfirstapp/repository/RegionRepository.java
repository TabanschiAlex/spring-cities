package com.example.springfirstapp.repository;

import com.example.springfirstapp.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface RegionRepository extends CrudRepository<User, Integer> {
}
