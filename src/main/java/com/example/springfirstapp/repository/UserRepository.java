package com.example.springfirstapp.repository;

import com.example.springfirstapp.entity.User;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface UserRepository extends PagingAndSortingRepository<User, Integer> {
    User queryUserByEmail(@Param("email") String email);

    @NotNull
    @Override
    Optional<User> findById(@NotNull Integer id);
}
