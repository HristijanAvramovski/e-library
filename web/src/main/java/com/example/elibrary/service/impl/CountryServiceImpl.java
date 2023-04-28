package com.example.elibrary.service.impl;

import com.example.elibrary.model.Country;
import com.example.elibrary.repository.CountryRepository;
import com.example.elibrary.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public Country save(String name, String continent) {
        Country country=new Country(name, continent);
        countryRepository.save(country);
        return country;
    }

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }
}
