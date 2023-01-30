package com.example.demo.web.controller;

import com.example.demo.service.AuthorService;
import com.example.demo.service.BookService;
import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.model.enumeration.Category;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    private final AuthorService authorService;

    public BookController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    /*@GetMapping
    public String listAllBooks(Model model){
        List<Book> books=bookService.listAll();
        model.addAttribute("books",books);
        return "books";
    }*/
    @GetMapping("/AddBook")
    public String addBookPage(Model model){
        List<Author> authors=authorService.listAll();
        List<Category> categories=new ArrayList<>();
        for (Category category : Category.values()) {
            categories.add(category);
        }
        model.addAttribute("authors",authors);
        model.addAttribute("categories",categories);
        return "add-book";
    }
    @GetMapping("/{id}/delete")
    public String deleteBook(@PathVariable Long id){
        bookService.deleteById(id);
        return "redirect:/books/paginate/1";
    }
    @GetMapping("/{id}/edit-form")
    public String getEditPage(@PathVariable Long id, Model model){
        Book book=bookService.findById(id);
        List<Author> authors=authorService.listAll();
        model.addAttribute("book1",book);
        model.addAttribute("authors",authors);
        return "add-book";
    }
    @PostMapping("/save")
    public String saveBook(@RequestParam(required = false) Long id,
                           @RequestParam String name,
                           @RequestParam Category category,
                           @RequestParam int availableCopies,
                           @RequestParam Long authorId){
        if(id!=null){
            bookService.edit(id, name, category, availableCopies, authorId);
        }
        else{
            bookService.save(name, category, availableCopies, authorId);
        }
        return "redirect:/books/paginate/1";
    }
    @GetMapping("/showBooksByCategory")
    public String showBooksByCategoriesPage(){
        return "show-books-categories.html";
    }
    @GetMapping("/paginate/{page}")
    public String paginateBooks(@PathVariable int page, Model model){
        Page<Book> bookPage=bookService.paginate(page);
        model.addAttribute("currentPage", bookPage.getNumber()+1);
        model.addAttribute("totalItems", bookPage.getTotalElements());
        model.addAttribute("totalPages", bookPage.getTotalPages());
        model.addAttribute("books",bookPage.getContent());
        return "books.html";
    }

}
