package com.example.elibrary.service.impl;

import com.example.elibrary.model.Author;
import com.example.elibrary.model.Book;
import com.example.elibrary.model.dto.BookDto;
import com.example.elibrary.model.exceptions.AuthorNotFoundException;
import com.example.elibrary.model.enumerations.Category;
import com.example.elibrary.model.exceptions.BookNotFoundException;
import com.example.elibrary.repository.AuthorRepository;
import com.example.elibrary.repository.BookRepository;
import com.example.elibrary.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public Optional<Book> save(BookDto bookDto) {
        Long authorId=bookDto.getAuthorId();
        Author author=authorRepository.findById(authorId).orElseThrow(()-> new AuthorNotFoundException(bookDto.getAuthorId()));
        Category cat=Category.valueOf(bookDto.getCategory());
        Book book=new Book(bookDto.getName(), cat, author, bookDto.getAvailableCopies());
        bookRepository.save(book);
        return Optional.of(book);
    }

    @Override
    public Book delete(Long id) {
        Book book=bookRepository.findById(id).orElseThrow(()-> new BookNotFoundException(id));
        bookRepository.delete(book);
        return book;
    }

    @Override
    public Book markAsTaken(Long id) {
        Book book=bookRepository.findById(id).orElseThrow(()-> new BookNotFoundException(id));
        Integer availableCopies = book.getAvailableCopies()-1;
        if(availableCopies > 0){
            book.setAvailableCopies(availableCopies);
            bookRepository.save(book);
        }
        return book;
    }

    @Override
    public Book edit(Long id, BookDto bookDto) {
        Book book=bookRepository.findById(id).orElseThrow(()-> new BookNotFoundException(id));
        Author author=authorRepository.findById(bookDto.getAuthorId()).orElseThrow(()-> new AuthorNotFoundException(bookDto.getAuthorId()));
        book.setName(bookDto.getName());
        Category cat=Category.valueOf(bookDto.getCategory());
        book.setCategory(cat);
        book.setAuthor(author);
        book.setAvailableCopies(bookDto.getAvailableCopies());
        bookRepository.save(book);
        return book;
    }

    @Override
    public Book findById(Long id) {
        Book book=bookRepository.findById(id).orElseThrow(()-> new BookNotFoundException(id));
        return book;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

}
