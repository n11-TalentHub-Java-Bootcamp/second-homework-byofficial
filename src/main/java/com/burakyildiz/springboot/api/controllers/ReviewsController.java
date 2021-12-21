package com.burakyildiz.springboot.api.controllers;

import com.burakyildiz.springboot.business.concretes.ReviewManager;
import com.burakyildiz.springboot.business.mapping.ReviewMapper;
import com.burakyildiz.springboot.entities.concretes.ProductReview;
import com.burakyildiz.springboot.entities.dtos.ProductReviewDto;
import com.burakyildiz.springboot.entities.dtos.ReviewDto;
import com.burakyildiz.springboot.entities.dtos.UserReviewDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewsController {
    @Autowired
    private ReviewManager reviewManager;

    @GetMapping("")
    public List<ReviewDto> findAll() {
        List<ProductReview> productReviewList = reviewManager.findAll();

        List<ReviewDto> reviewDtoList = ReviewMapper.INSTANCE.convertAllReviewListToReviewDtoList(productReviewList);

        return reviewDtoList;
    }


    @GetMapping("/user/{id}")
    public List<UserReviewDto> findAllUserReviewsList(@PathVariable Long id) {

        List<ProductReview> productReviewList = reviewManager.findAllUserReviewList(id);

        List<UserReviewDto> reviewDtoList = ReviewMapper.INSTANCE.convertAllProductReviewListToUserReviewDtoList(productReviewList);

        return reviewDtoList;
    }

    @GetMapping("/product/{id}")
    public List<ProductReviewDto> findAllProductReviewsList(@PathVariable Long id) {
        List<ProductReview> productReviewList = reviewManager.findAllProductReviewList(id);

        List<ProductReviewDto> reviewDtoList = ReviewMapper.INSTANCE.convertAllProductReviewListToProductReviewDtoList(productReviewList);

        return reviewDtoList;
    }

    @PostMapping("")
    public ResponseEntity<Object> saveReview(@RequestBody ReviewDto reviewDto) {

        ProductReview review = ReviewMapper.INSTANCE.convertReviewDtoToProductReview(reviewDto);

        review = reviewManager.save(review);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(review.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable Long id) {
        reviewManager.deleteById(id);
    }

}
