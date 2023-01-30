package com.example.demo;

import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.model.Country;
import com.example.demo.model.enumeration.Category;
import com.example.demo.model.exceptions.BookNotFoundException;
import com.example.demo.repository.jpa.AuthorRepository;
import com.example.demo.repository.jpa.BookRepository;
import com.example.demo.service.BookService;
import com.example.demo.service.impl.BookServiceImpl;
import net.bytebuddy.matcher.ModifierMatcher;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TestBookService {
    @Mock
    Book book;
    @Mock
    BookService bookService;
    @Mock
    BookRepository bookRepository;
    @Mock
    AuthorRepository authorRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
//        this.book = Mockito.spy(new Book(1L));
        this.bookService = Mockito.spy(new BookServiceImpl(bookRepository, authorRepository));
        this.bookService = mock(BookServiceImpl.class);
    }
    @Test
    public void testFindById(){
        Country country = new Country("Zemja","Kontinent");
        Author author = new Author("AuthorName","AuthorSurname",country);
        Book book = new Book(1L,"Book",Category.BIOGRAPHY,10,author);
        when(bookService.findById(Mockito.anyLong())).thenReturn(book);
        Assert.assertNotNull(book);

    }
    @Test
    public void testFindByIdNotFound(){
        Country country=new Country("Zemja","Kontinent");
        Author author=new Author("AuthorName","AuthorSurname",country);
        Book book=new Book("Book",Category.BIOGRAPHY,10,author);
        book.setId(1L);
        when(bookRepository.save(book)).thenReturn(book);
        //Mockito.when(bookRepository.findById(2L)).thenReturn(Optional.of(book));
        Assert.assertThrows("BookNotFoundException",
                BookNotFoundException.class,
                ()->this.bookService.findById(1L));
        Mockito.verify(this.bookService).findById(1L);
    }

    @Test
    public void testFindAll(){
        List<Book> books=new ArrayList<>();
        Country country1=new Country("Zemja1","Kontinent1");
        Author author1=new Author("AuthorName1","AuthorSurname1",country1);
        Country country2=new Country("Zemja2","Kontinent2");
        Author author2=new Author("AuthorName2","AuthorSurname2",country2);
        Book book1=new Book("Book1",Category.BIOGRAPHY,10,author1);
        Book book2=new Book("Book2",Category.BIOGRAPHY,15,author2);
        books.add(book1);
        books.add(book2);
        when(bookService.listAll()).thenReturn(books);
        Assert.assertEquals(2,books.size());
        Assert.assertNotNull(books);
        Mockito.verify(bookService).listAll();
    }
    /*@Test
    public void testSave(){
        Country country1=new Country("Zemja1","Kontinent1");
        Author author1=new Author("AuthorName1","AuthorSurname1",country1);
        Book book=new Book("Book1",Category.BIOGRAPHY,10,author1);
        when(bookService.save("Book1",Category.BIOGRAPHY,10,author1)).thenReturn(book);
        Assert.assertNotNull(b);
    }*/
}
