package com.example.elibrary.service.impl;

import com.example.elibrary.model.Author;
import com.example.elibrary.model.Country;
import com.example.elibrary.model.exceptions.AuthorNotFoundException;
import com.example.elibrary.model.exceptions.CountryNotFoundException;
import com.example.elibrary.repository.AuthorRepository;
import com.example.elibrary.repository.CountryRepository;
import com.example.elibrary.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public Author findById(Long id) {
        Author author=authorRepository.findById(id).orElseThrow(()-> new AuthorNotFoundException(id));
        return author;
    }

    @Override
    public Author save(String name, String surname, Long countryId) {
        Country country=countryRepository.findById(countryId).orElseThrow(()-> new CountryNotFoundException(countryId));
        Author author=new Author(name, surname, country);
        authorRepository.save(author);
        return author;
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }
}
