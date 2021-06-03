package com.example.springfirstapp.service;

import com.example.springfirstapp.config.jwt.JwtProvider;
import com.example.springfirstapp.dto.AuthorizationDto;
import com.example.springfirstapp.entity.Role;
import com.example.springfirstapp.entity.User;
import com.example.springfirstapp.exception.user.UserNotFoundException;
import com.example.springfirstapp.repository.RoleRepository;
import com.example.springfirstapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private RoleRepository roleRepository;

  @Autowired
  private JwtProvider jwtProvider;

  @Autowired
  private BCryptPasswordEncoder passwordEncoder;

  public String register(AuthorizationDto authorizationDto) {
    try {
      Role role = roleRepository.findByName("user");
      User user = new User();
      user.setRole(role);
      user.setPassword(passwordEncoder.encode(authorizationDto.getPassword()));
      user.setEmail(authorizationDto.getEmail());
      userRepository.save(user);

      return jwtProvider.generateToken(user.getEmail());
    } catch (Exception e) {
      throw e;
    }
  }

  public String login(AuthorizationDto authorizationDto) throws UserNotFoundException {
    try {
      User user = userRepository.queryUserByEmail(authorizationDto.getEmail());
      boolean isMatch = passwordEncoder.matches(authorizationDto.getPassword(), user.getEmail());

      if (!isMatch) {
        throw new UserNotFoundException();
      }

      return jwtProvider.generateToken(user.getEmail());
    } catch (Exception e) {
      throw e;
    }
  }

  public List<User> getAllUsers() {
    return (List<User>) userRepository.findAll();
  }

  public User findByEmail(String email) {
    return userRepository.queryUserByEmail(email);
  }

  public Optional<User> findById(Integer id) {
    return userRepository.findById(id);
  }
}
