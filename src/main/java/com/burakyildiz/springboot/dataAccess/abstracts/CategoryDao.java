package com.burakyildiz.springboot.dataAccess.abstracts;

import com.burakyildiz.springboot.entities.concretes.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryDao extends JpaRepository<Category, Long> {
    List<Category> findAllByTopCategoryIsNullOrderByCategoryNameDesc();

    List<Category> findAllByCategoryNameEndsWith(String name);
}
