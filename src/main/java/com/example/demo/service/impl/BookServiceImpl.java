package com.example.demo.service.impl;

import com.example.demo.model.CountBookCategory;
import com.example.demo.repository.jpa.AuthorRepository;
import com.example.demo.repository.jpa.BookRepository;
import com.example.demo.service.BookService;
import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.model.exceptions.AuthorNotFoundException;
import com.example.demo.model.exceptions.BookNotFoundException;
import com.example.demo.model.enumeration.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private final BookRepository bookRepository;
    @Autowired
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> listAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book save(String name, Category category, int availableCopies, Long authorId) {
        Author author=authorRepository.findById(authorId).orElseThrow(()-> new AuthorNotFoundException(authorId));
        Book book=new Book(name,category,availableCopies,author);
        bookRepository.save(book);
        return book;
    }

    @Override
    public Book findById(Long bookId) {
        return bookRepository.findById(bookId).orElseThrow(()-> new BookNotFoundException(bookId));
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Book edit(Long id, String name, Category category, int availableCopies, Long authorId) {
        Book book=bookRepository.findById(id).orElseThrow(()->new BookNotFoundException(id));
        book.setName(name);
        book.setCategory(category);
        book.setAvailableCopies(availableCopies);
        Author author=authorRepository.findById(authorId).orElseThrow(()->new AuthorNotFoundException(authorId));
        book.setAuthor(author);
        bookRepository.save(book);
        return book;
    }

    @Override
    public List<CountBookCategory> countBookByCategory() {
        int numThriller=0;
        int numHistory=0;
        int numFantasy=0;
        int numBiography=0;
        int numClassics=0;
        int numDrama=0;
        int numNovel=0;
        List<Book> books=bookRepository.findAll();
        for(int i=0;i<books.size();i++){
            if(books.get(i).getCategory().equals(Category.THRILER)){
                numThriller++;
            }
            else if(books.get(i).getCategory().equals(Category.HISTORY)){
                numHistory++;
            }
            else if(books.get(i).getCategory().equals(Category.FANTASY)){
                numFantasy++;
            }
            else if(books.get(i).getCategory().equals(Category.BIOGRAPHY)){
                numBiography++;
            }
            else if(books.get(i).getCategory().equals(Category.CLASSICS)){
                numClassics++;
            }
            else if(books.get(i).getCategory().equals(Category.DRAMA)){
                numDrama++;
            }
            else if(books.get(i).getCategory().equals(Category.NOVEL)){
                numNovel++;
            }
        }
        CountBookCategory thriller=new CountBookCategory(Category.THRILER, numThriller);
        CountBookCategory history=new CountBookCategory(Category.HISTORY, numHistory);
        CountBookCategory fantasy=new CountBookCategory(Category.FANTASY, numFantasy);
        CountBookCategory biography=new CountBookCategory(Category.BIOGRAPHY, numBiography);
        CountBookCategory classic=new CountBookCategory(Category.CLASSICS, numClassics);
        CountBookCategory drama=new CountBookCategory(Category.DRAMA, numDrama);
        CountBookCategory novel=new CountBookCategory(Category.NOVEL, numNovel);
        List<CountBookCategory> booksByCategory=new ArrayList<>();
        booksByCategory.add(thriller);
        booksByCategory.add(history);
        booksByCategory.add(fantasy);
        booksByCategory.add(biography);
        booksByCategory.add(classic);
        booksByCategory.add(drama);
        booksByCategory.add(novel);
        return booksByCategory;
    }

    @Override
    public Page<Book> paginate(int page) {
        int size=5;
        Pageable pageable= PageRequest.of(page-1,size);
        Page<Book> books=bookRepository.findAll(pageable);
        return books;
    }

}
