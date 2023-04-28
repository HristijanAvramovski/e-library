package com.example.elibrary.service;

import com.example.elibrary.model.Country;

import java.util.List;

public interface CountryService {
    public Country save(String name, String continent);
    public List<Country> findAll();
}
