package com.burakyildiz.springboot.business.concretes;

import com.burakyildiz.springboot.business.abstracts.ICategoryService;
import com.burakyildiz.springboot.dataAccess.abstracts.CategoryDao;
import com.burakyildiz.springboot.entities.concretes.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryManager implements ICategoryService {
    @Autowired
    private CategoryDao categoryDao;

    @Override
    public List<Category> findAll() {
        return categoryDao.findAll();
    }

    @Override
    public Category findById(Long id) {
        Optional<Category> optionalCategory = categoryDao.findById(id);

        Category category = null;
        if (optionalCategory.isPresent()) {
            category = optionalCategory.get();
        }

        return category;
    }

    @Override
    public Category save(Category category) {
        return categoryDao.save(category);
    }

    @Override
    public void delete(Category category) {
        categoryDao.delete(category);
    }

    @Override
    public void deleteById(Long id) {
        categoryDao.deleteById(id);
    }

    @Override
    public long count() {
        return categoryDao.count();
    }

    @Override
    public List<Category> findAllByTopCategoryIsNullOrderByCategoryNameDesc() {
        return categoryDao.findAllByTopCategoryIsNullOrderByCategoryNameDesc();
    }

    @Override
    public List<Category> findAllByCategoryNameEndsWith(String name) {
        return categoryDao.findAllByCategoryNameEndsWith(name);
    }
}
