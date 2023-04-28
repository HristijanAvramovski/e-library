package com.example.elibrary.web;

import com.example.elibrary.model.Book;
import com.example.elibrary.model.dto.BookDto;
import com.example.elibrary.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @GetMapping()
    public List<Book> findAll(){
        return bookService.findAll();
    }
    @PostMapping("/add")
    public ResponseEntity<Book> save(@RequestBody BookDto bookDto){
        return this.bookService.save(bookDto)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
    @GetMapping("/{id}")
    public Book getBook(@PathVariable Long id){
        return bookService.findById(id);
    }
    @DeleteMapping("/delete/{id}")
    public Book delete(@PathVariable Long id){
        return bookService.delete(id);
    }
    @PutMapping("/edit/{id}")
    public Book edit(@PathVariable Long id,
                     @RequestBody BookDto bookDto){
        return bookService.edit(id, bookDto);
    }
    @GetMapping("/markAsTaken/{id}")
    public Book markAsTaken(@PathVariable Long id){
        return bookService.markAsTaken(id);
    }
}
