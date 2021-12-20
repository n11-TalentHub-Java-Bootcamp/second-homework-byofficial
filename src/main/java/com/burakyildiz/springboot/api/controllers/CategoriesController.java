package com.burakyildiz.springboot.api.controllers;

import com.burakyildiz.springboot.business.concretes.CategoryManager;
import com.burakyildiz.springboot.business.concretes.ProductManager;
import com.burakyildiz.springboot.business.mapping.CategoryConverter;
import com.burakyildiz.springboot.business.mapping.ProductConverter;
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

    @GetMapping("")
    public List<CategoryDto> findAll() {
        List<Category> categoryList = categoryManager.findAll();

        List<CategoryDto> categoryDtoList = CategoryConverter.INSTANCE.convertAllCategoryListToCategoryDtoList(categoryList);

        return categoryDtoList;
    }

    @GetMapping("/{id}")
    public Category findById(@PathVariable Long id) {

        Category category = categoryManager.findById(id);

        return category;
    }

    @PostMapping("")
    public ResponseEntity<Object> save(@RequestBody CategoryDto categoryDto) {

        Category category = CategoryConverter.INSTANCE.convertCategoryDtoToCategory(categoryDto);


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

    @PutMapping("")
    public CategoryDto update(@RequestBody CategoryDto categoryDto) {

        Category category = CategoryConverter.INSTANCE.convertCategoryDtoToCategory(categoryDto);


        if (category.getTopCategory() != null && category.getTopCategory().getId() == null) {
            category.setTopCategory(null);
        }

        category = categoryManager.save(category);

        CategoryDto categoryDtoResult = CategoryConverter.INSTANCE.convertCategoryToCategoryDto(category);

        return categoryDtoResult;
    }

    @DeleteMapping("/{id}")
    public void delete(Long id) {
        categoryManager.deleteById(id);
    }


    @GetMapping("/{id}/products")
    public List<ProductDetailDto> findAllUrunByKategoriId(@PathVariable Long id) {
        List<Product> urunList = productManager.findAllByCategoryOrderByIdDesc(id);

        List<ProductDetailDto> productDetailDtoList = ProductConverter.INSTANCE.convertAllProductListToProductDetailDtoList(urunList);

        return productDetailDtoList;
    }
}
