package com.burakyildiz.springboot.business.abstracts;

import com.burakyildiz.springboot.entities.concretes.Product;
import com.burakyildiz.springboot.entities.concretes.ProductReview;

import java.util.List;

public interface IReviewService {
    List<ProductReview> findAll();

    ProductReview findById(Long id);

    ProductReview save(ProductReview productReview);

    void delete(ProductReview productReview);

    void deleteById(Long id);

    long count();
}
