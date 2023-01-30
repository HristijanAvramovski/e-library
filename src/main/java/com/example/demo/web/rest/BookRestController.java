package com.example.demo.web.rest;

import com.example.demo.model.Book;
import com.example.demo.model.CountBookCategory;
import com.example.demo.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api/books")
public class BookRestController {
    private final BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }
    @GetMapping
    public List<CountBookCategory> getBooksByCategories(){
        return bookService.countBookByCategory();
    }
    @GetMapping("/paginate/{page}")
    public Page<Book> paginateBooks(@PathVariable int page){
        return bookService.paginate(page);
    }
}
