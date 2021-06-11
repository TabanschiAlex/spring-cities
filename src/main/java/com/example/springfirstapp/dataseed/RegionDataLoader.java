package com.example.springfirstapp.dataseed;

import com.example.springfirstapp.entity.Region;
import com.example.springfirstapp.repository.CountryRepository;
import com.example.springfirstapp.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RegionDataLoader implements CommandLineRunner {
    @Autowired
    RegionRepository regionRepository;

    @Autowired
    CountryRepository countryRepository;

    @Override
    public void run(String... args) {
        loadRegionData();
    }

    private void loadRegionData() {
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
}

