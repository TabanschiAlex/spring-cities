package com.example.springfirstapp.dataseed;

import com.example.springfirstapp.entity.Role;
import com.example.springfirstapp.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class RoleDataLoader implements CommandLineRunner {
    @Autowired
    RoleRepository roleRepository;

    @Override
    public void run(String... args) {
        loadRoleData();
    }

    private void loadRoleData() {
        if (roleRepository.count() == 0) {
            Role admin = new Role();
            Role user = new Role();
            admin.setName("admin");
            user.setName("user");
            roleRepository.save(admin);
            roleRepository.save(user);
        }

        System.out.println(roleRepository.count());
    }
}
