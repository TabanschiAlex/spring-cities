package com.example.springfirstapp.dataseed;

import com.example.springfirstapp.dto.AuthorizationDto;
import com.example.springfirstapp.entity.*;
import com.example.springfirstapp.repository.*;
import com.example.springfirstapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RunSeeds implements CommandLineRunner {
    @Autowired
    CityRepository cityRepository;

    @Autowired
    RegionRepository regionRepository;

    @Autowired
    CountryRepository countryRepository;

    @Autowired
    PermissionRepository permissionRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    private UserService userService;


    @Override
    public void run(String... args) {
        loadRoleData();
        loadUserData();
        loadPermissionData();
        loadCountryData();
        loadRegionData();
        loadCityData();
    }

    public void loadCityData() {
        if (cityRepository.count() == 0) {

            City city1 = new City("New York", regionRepository.findByName("New York"));
            City city2 = new City("Buffalo", regionRepository.findByName("New York"));
            City city3 = new City("Los Angeles", regionRepository.findByName("California"));
            City city4 = new City("San Diego", regionRepository.findByName("California"));
            City city5 = new City("Chisinau", regionRepository.findByName("Chisinau"));
            City city6 = new City("Balti", regionRepository.findByName("Balti"));

            cityRepository.save(city1);
            cityRepository.save(city2);
            cityRepository.save(city3);
            cityRepository.save(city4);
            cityRepository.save(city5);
            cityRepository.save(city6);
        }

        System.out.println(cityRepository.count());
    }

    public void loadCountryData() {
        if (countryRepository.count() == 0) {
            Country country1 = new Country("USA", "123");
            Country country2 = new Country("Moldova", "373");

            countryRepository.save(country1);
            countryRepository.save(country2);
        }

        System.out.println(countryRepository.count());
    }

    public void loadPermissionData() {
        if (permissionRepository.count() == 0) {
            Permission permission1 = new Permission("/**", roleRepository.findByName("admin"));
            Permission permission2 = new Permission("/user/**", roleRepository.findByName("user"));

            permissionRepository.save(permission1);
            permissionRepository.save(permission2);
        }

        System.out.println(permissionRepository.count());
    }

    public void loadRegionData() {
        if (regionRepository.count() == 0) {

            Region region1 = new Region("New York", countryRepository.findByName("USA"));
            Region region2 = new Region("California", countryRepository.findByName("USA"));
            Region region3 = new Region("Chisinau", countryRepository.findByName("Moldova"));
            Region region4 = new Region("Balti", countryRepository.findByName("Moldova"));

            regionRepository.save(region1);
            regionRepository.save(region2);
            regionRepository.save(region3);
            regionRepository.save(region4);
        }

        System.out.println(countryRepository.count());
    }

    public void loadRoleData() {
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

    public void loadUserData() {
        if (userRepository.count() == 0) {
            AuthorizationDto user1 = new AuthorizationDto("test@test.com", "123");
            AuthorizationDto user2 = new AuthorizationDto("admin", "123");

            userService.register(user1);
            userService.register(user2);
        }
        System.out.println(userRepository.count());
    }
}
