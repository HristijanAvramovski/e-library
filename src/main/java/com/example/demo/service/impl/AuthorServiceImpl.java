package com.example.demo.service.impl;

import com.example.demo.repository.jpa.AuthorRepository;
import com.example.demo.service.AuthorService;
import com.example.demo.model.Author;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> listAll() {
        return authorRepository.findAll();
    }
}
