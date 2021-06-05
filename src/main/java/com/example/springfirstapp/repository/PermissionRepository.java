package com.example.springfirstapp.repository;

import com.example.springfirstapp.entity.Permission;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PermissionRepository extends PagingAndSortingRepository<Permission, Integer> {
}
