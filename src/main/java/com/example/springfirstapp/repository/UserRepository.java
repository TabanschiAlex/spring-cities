package com.example.springfirstapp.repository;

import com.example.springfirstapp.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface UserRepository extends PagingAndSortingRepository<User, Integer> {
  User findByEmail(String email);
  Optional<User> findById(Integer id);
}
