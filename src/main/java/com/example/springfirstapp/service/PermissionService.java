package com.example.springfirstapp.service;

import com.example.springfirstapp.entity.Permission;
import com.example.springfirstapp.repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionService {
  @Autowired
  private PermissionRepository permissionRepository;

  public List<Permission> getAllPermissions() {
    return (List<Permission>) permissionRepository.findAll();
  }

  public HttpSecurity generatePermissions(HttpSecurity http) throws Exception {
    List<Permission> permissions = getAllPermissions();

    for (Permission permission : permissions) {
      http.authorizeRequests().antMatchers(permission.getPermission()).hasAuthority(permission.getRole().getName());
    }

    http.authorizeRequests().antMatchers("/**").permitAll();

    return http;
  }
}
