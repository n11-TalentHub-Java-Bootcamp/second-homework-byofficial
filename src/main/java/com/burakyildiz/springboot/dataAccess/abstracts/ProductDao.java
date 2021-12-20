package com.burakyildiz.springboot.dataAccess.abstracts;

import com.burakyildiz.springboot.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDao extends JpaRepository<Product, Long> {
    @Query("select product from Product product where product.category.id = :categoryId")
    List<Product> findAllByCategoryOrderByIdDesc(Long categoryId);
}
