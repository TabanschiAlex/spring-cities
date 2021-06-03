package com.example.springfirstapp.repository;

import com.example.springfirstapp.entity.Role;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RoleRepository extends PagingAndSortingRepository<Role, Integer> {
   Role findByName(String name);
}
