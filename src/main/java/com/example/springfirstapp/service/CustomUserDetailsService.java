package com.example.springfirstapp.service;

import com.example.springfirstapp.config.CustomUserDetails;
import com.example.springfirstapp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements UserDetailsService {
  @Autowired
  private UserService userService;

  @Override
  public CustomUserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    User user = userService.findByEmail(email);
    return CustomUserDetails.fromUserEntityToCustomUserDetails(user);
  }
}
