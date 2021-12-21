package com.burakyildiz.springboot.business.abstracts;

import com.burakyildiz.springboot.entities.concretes.Category;

import java.util.List;

public interface ICategoryService  {
    List<Category> findAll();

    Category findById(Long id);

    public Category save(Category category);

    void delete(Category category);

    void deleteById(Long id);

    long count();

    List<Category> findAllByTopCategoryIsNullOrderByCategoryNameDesc();

    List<Category> findAllByCategoryNameEndsWith(String name);
}
