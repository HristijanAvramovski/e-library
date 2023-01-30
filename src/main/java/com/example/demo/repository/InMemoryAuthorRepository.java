/*package com.example.demo.repository;

import com.example.demo.InMemoryStorage.DataHolder;
import com.example.demo.model.Author;

import java.util.Optional;
import java.util.List;

public class InMemoryAuthorRepository {
    public Optional<Author> findById(Long id){
        return DataHolder.authors.stream().filter(x->x.getId().equals(id)).findFirst();
    }
    public List<Author> findAll() {
        return DataHolder.authors;
    }
}
*/