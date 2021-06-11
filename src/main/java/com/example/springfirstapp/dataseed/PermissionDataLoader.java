package com.example.springfirstapp.dataseed;

import com.example.springfirstapp.entity.Permission;
import com.example.springfirstapp.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PermissionDataLoader implements CommandLineRunner {
    @Autowired
    PermissionRepository permissionRepository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public void run(String... args) {
        loadPermissionData();
    }

    private void loadPermissionData() {
        if (permissionRepository.count() == 0) {
            Permission permission1 = new Permission("/**", roleRepository.findByName("admin"));
            Permission permission2 = new Permission("/user/**", roleRepository.findByName("user"));

            permissionRepository.save(permission1);
            permissionRepository.save(permission2);
        }

        System.out.println(permissionRepository.count());
    }
}
