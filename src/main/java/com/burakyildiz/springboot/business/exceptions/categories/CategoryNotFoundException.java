package com.burakyildiz.springboot.business.exceptions.categories;

public class CategoryNotFoundException extends RuntimeException{
    public CategoryNotFoundException(String message) {
        super(message);
    }
}