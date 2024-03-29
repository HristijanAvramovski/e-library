package com.example.elibrary.model.exceptions;

public class AuthorNotFoundException extends RuntimeException{
    public AuthorNotFoundException(Long id){
        super(String.format("Author with id: %d is not found", id));
    }
}
