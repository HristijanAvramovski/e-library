package com.example.elibrary.service;

import com.example.elibrary.model.Book;
import com.example.elibrary.model.dto.BookDto;

import java.util.List;
import java.util.Optional;

public interface BookService {
    public Optional<Book> save(BookDto bookDto);
    public Book delete(Long id);
    public Book markAsTaken(Long id);
    public Book edit(Long id, BookDto bookDto);
    public Book findById(Long id);
    public List<Book> findAll();
}
