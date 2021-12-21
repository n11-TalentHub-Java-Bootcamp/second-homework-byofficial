package com.burakyildiz.springboot.api.controllers;

import com.burakyildiz.springboot.business.concretes.CategoryManager;
import com.burakyildiz.springboot.business.concretes.ProductManager;
import com.burakyildiz.springboot.business.exceptions.categories.CategoryNotFoundException;
import com.burakyildiz.springboot.business.mapping.CategoryMapper;
import com.burakyildiz.springboot.business.mapping.ProductMapper;
import com.burakyildiz.springboot.entities.concretes.Category;
import com.burakyildiz.springboot.entities.concretes.Product;
import com.burakyildiz.springboot.entities.dtos.CategoryDto;
import com.burakyildiz.springboot.entities.dtos.ProductDetailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoriesController {
    @Autowired
    private CategoryManager categoryManager;

    @Autowired
    private ProductManager productManager;

    //[GET] https://localhost:8080/api/categories/
    @GetMapping("")
    public List<CategoryDto> findAll() {
        List<Category> categoryList = categoryManager.findAll();

        //Sistemde hiç kategori yoksa
        if (categoryList.size() == 0) {
            throw new CategoryNotFoundException("There are no category!");
        }

        List<CategoryDto> categoryDtoList = CategoryMapper.INSTANCE.convertAllCategoryListToCategoryDtoList(categoryList);

        return categoryDtoList;
    }

    //[GET] https://localhost:8080/api/categories/{id}
    @GetMapping("/{id}")
    public Category findById(@PathVariable Long id) {
        Category category = categoryManager.findById(id);

        //Belirtilen id ait kategori sistemde yoksa
        if (category == null) {
            throw new CategoryNotFoundException("Category not found! ID: " + id);
        }

        return category;
    }

    //[GET] https://localhost:8080/api/categories/{id}/products
    @GetMapping("/{id}/products")
    public List<ProductDetailDto> findAllProductByCategoryId(@PathVariable Long id) {
        List<Product> urunList = productManager.findAllByCategoryOrderByIdDesc(id);

        List<ProductDetailDto> productDetailDtoList = ProductMapper.INSTANCE.convertAllProductListToProductDetailDtoList(urunList);

        return productDetailDtoList;
    }

    //[POST] https://localhost:8080/api/categories/
    @PostMapping("")
    public ResponseEntity<Object> save(@RequestBody CategoryDto categoryDto) {

        Category category = CategoryMapper.INSTANCE.convertCategoryDtoToCategory(categoryDto);


        if (category.getTopCategory() != null && category.getTopCategory().getId() == null) {
            category.setTopCategory(null);
        }

        category = categoryManager.save(category);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(category.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    //[PUT] https://localhost:8080/api/categories/
    @PutMapping("")
    public CategoryDto update(@RequestBody CategoryDto categoryDto) {

        Category category = CategoryMapper.INSTANCE.convertCategoryDtoToCategory(categoryDto);

        if (category.getTopCategory() != null && category.getTopCategory().getId() == null) {
            category.setTopCategory(null);
        }

        category = categoryManager.save(category);

        CategoryDto categoryDtoResult = CategoryMapper.INSTANCE.convertCategoryToCategoryDto(category);

        return categoryDtoResult;
    }

    //[DELETE] https://localhost:8080/api/categories/{id}
    @DeleteMapping("/{id}")
    public void delete(Long id) {
        Category category = categoryManager.findById(id);

        //Belirtilen id ait kategori sistemde yoksa
        if (category == null) {
            throw new CategoryNotFoundException("Category not found! ID: " + id);
        }

        categoryManager.deleteById(id);
    }


}
