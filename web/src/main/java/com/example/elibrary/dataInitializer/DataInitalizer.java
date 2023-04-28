package com.example.elibrary.dataInitializer;

import com.example.elibrary.model.Author;
import com.example.elibrary.model.Book;
import com.example.elibrary.model.Country;
import com.example.elibrary.model.enumerations.Category;
import com.example.elibrary.repository.AuthorRepository;
import com.example.elibrary.repository.BookRepository;
import com.example.elibrary.repository.CountryRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
/*
@Component
public class DataInitalizer {
    private final BookRepository bookRepository;
    private final CountryRepository countryRepository;
    private final AuthorRepository authorRepository;

    public DataInitalizer(BookRepository bookRepository, CountryRepository countryRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.countryRepository = countryRepository;
        this.authorRepository = authorRepository;
    }
    @PostConstruct
    public void init(){
        Country country1=new Country("North Macedonia","Europe");
        countryRepository.save(country1);
        Country country2=new Country("Germany","Europe");
        countryRepository.save(country2);
        Country country3=new Country("United Kingdom","Europe");
        countryRepository.save(country3);
        Author author1=new Author("William", "Shakespeare",country1);
        authorRepository.save(author1);
        Author author2=new Author("Charles", "Dickens", country2);
        authorRepository.save(author2);
        Author author3=new Author("Agatha", "Christie",country3);
        authorRepository.save(author3);
        Book book1=new Book("Don Quixote", Category.BIOGRAPHY,author1,50);
        bookRepository.save(book1);
        Book book2=new Book("A Tale of Two Cities", Category.NOVEL,author2,27);
        bookRepository.save(book2);
        Book book3=new Book("The Little Prince", Category.THRILER,author3,13);
        bookRepository.save(book3);
    }
}
*/