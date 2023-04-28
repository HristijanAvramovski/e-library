package com.example.elibrary.web;

import com.example.elibrary.model.Author;
import com.example.elibrary.service.AuthorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/authors")
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }
    @GetMapping
    public List<Author> findAll(){
        return authorService.findAll();
    }
    @PostMapping("/save")
    public Author save(@RequestParam String name,
                       @RequestParam String surname,
                       @RequestParam Long countryId){
        return authorService.save(name, surname, countryId);
    }
}
