package com.example.springfirstapp.dataseed;


import com.example.springfirstapp.entity.Country;
import com.example.springfirstapp.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CountryDataLoader implements CommandLineRunner {
    @Autowired
    CountryRepository countryRepository;

    @Override
    public void run(String... args) {
        loadCountryData();
    }

    private void loadCountryData() {
        if (countryRepository.count() == 0) {
            Country country1 = new Country("USA", "123");
            Country country2 = new Country("Moldova", "373");

            countryRepository.save(country1);
            countryRepository.save(country2);
        }

        System.out.println(countryRepository.count());
    }
}

