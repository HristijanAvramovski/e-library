package com.example.demo.service;

import com.example.demo.model.Book;
import com.example.demo.model.CountBookCategory;
import com.example.demo.model.enumeration.Category;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BookService {
    public List<Book> listAll();
    public Book save(String name, Category category, int availableCopies, Long authorId);
    public Book findById(Long id);
    public void deleteById(Long id);
    public Book edit(Long id, String name, Category category, int availableCopies, Long authorId);
    public List<CountBookCategory> countBookByCategory();
    public Page<Book> paginate(int page);
}
