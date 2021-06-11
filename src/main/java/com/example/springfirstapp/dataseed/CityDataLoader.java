package com.example.springfirstapp.dataseed;

import com.example.springfirstapp.entity.City;
import com.example.springfirstapp.repository.CityRepository;
import com.example.springfirstapp.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CityDataLoader implements CommandLineRunner {
    @Autowired
    CityRepository cityRepository;

    @Autowired
    RegionRepository regionRepository;

    @Override
    public void run(String... args) {
        loadCityData();
    }

    private void loadCityData() {
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
}
