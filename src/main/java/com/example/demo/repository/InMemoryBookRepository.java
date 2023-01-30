/*package com.example.demo.repository;

import com.example.demo.InMemoryStorage.DataHolder;
import com.example.demo.model.Book;

import java.util.Optional;
import java.util.List;

public class InMemoryBookRepository {
    public Optional<Book> findById(Long id){
        return DataHolder.books.stream().filter(x->x.getId().equals(id)).findFirst();
    }
    public List<Book> findAll(){
        return DataHolder.books;
    }
    public Book save(Book book){
        DataHolder.books.removeIf(x->x.getId().equals(book.getId()));
        DataHolder.books.add(book);
        return book;
    }
    public void delete(Book book){
        DataHolder.books.remove(book);
    }
}
*/