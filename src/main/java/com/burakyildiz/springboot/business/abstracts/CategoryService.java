package com.burakyildiz.springboot.business.abstracts;

import com.burakyildiz.springboot.entities.concretes.Category;

import java.util.List;

public interface CategoryService {

    List<Category> findAll();

    Category findById(Long id);

    Category save(Category category);

    void delete(Category category);

    void deleteById(Long id);

    long count();

    List<Category> findAllByTopCategoryIsNullOrderByCategoryNameDesc();

    List<Category> findAllByCategoryNameEndsWith(String name);
}
