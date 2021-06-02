package com.example.springfirstapp.repository;

import com.example.springfirstapp.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User, Integer> {
}
