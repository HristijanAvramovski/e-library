package com.example.elibrary.service;

import com.example.elibrary.model.Author;

import java.util.List;

public interface AuthorService {
    public Author findById(Long id);
    public Author save(String name, String surname, Long countryId);
    public List<Author> findAll();
}
