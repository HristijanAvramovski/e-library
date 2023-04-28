package com.example.elibrary.web;

import com.example.elibrary.model.enumerations.Category;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/categories")
public class BookCategoryController {
    @GetMapping
    public List<Category> listAll(){
        List<Category> categories= List.of(Category.values());
        return categories;
    }
}
