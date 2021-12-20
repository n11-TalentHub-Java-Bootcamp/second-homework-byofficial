package com.burakyildiz.springboot.business.abstracts;

import com.burakyildiz.springboot.entities.concretes.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    Product findById(Long id);

    Product save(Product product);

    void delete(Product product);

    void deleteById(Long id);

    long count();

}
