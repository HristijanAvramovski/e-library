package com.example.demo.model;

import com.example.demo.model.enumeration.Category;
import lombok.Data;

@Data
public class CountBookCategory {
    private Category category;
    private int numOfBooks;

    public CountBookCategory(Category category, int numOfBooks) {
        this.category = category;
        this.numOfBooks = numOfBooks;
    }
}
