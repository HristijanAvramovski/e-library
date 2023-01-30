package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import com.example.demo.model.enumeration.Category;
@Entity
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Category category;
    private int availableCopies;
    @ManyToOne
    private Author author;

    public Book() {
    }

    public Book(Long id) {
        this.id = id;
    }


    public Book(String name, Category category, int availableCopies, Author author) {
        this.name = name;
        this.category = category;
        this.availableCopies = availableCopies;
        this.author = author;
    }

    public Book(Long id, String name, Category category, int availableCopies, Author author) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.availableCopies = availableCopies;
        this.author = author;
    }
}
