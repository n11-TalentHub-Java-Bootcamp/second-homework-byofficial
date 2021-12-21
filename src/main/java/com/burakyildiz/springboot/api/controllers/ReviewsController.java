package com.burakyildiz.springboot.api.controllers;

import com.burakyildiz.springboot.business.concretes.ReviewManager;
import com.burakyildiz.springboot.business.mapping.CategoryConverter;
import com.burakyildiz.springboot.business.mapping.ProductConverter;
import com.burakyildiz.springboot.business.mapping.ReviewConverter;
import com.burakyildiz.springboot.entities.concretes.Category;
import com.burakyildiz.springboot.entities.concretes.ProductReview;
import com.burakyildiz.springboot.entities.dtos.CategoryDto;
import com.burakyildiz.springboot.entities.dtos.ProductReviewDto;
import com.burakyildiz.springboot.entities.dtos.ReviewDto;
import com.burakyildiz.springboot.entities.dtos.UserReviewDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewsController {
    @Autowired
    private ReviewManager reviewManager;

    @GetMapping("")
    public List<ReviewDto> findAll() {
        List<ProductReview> productReviewList = reviewManager.findAll();

        List<ReviewDto> reviewDtoList = ReviewConverter.INSTANCE.convertAllReviewListToReviewDtoList(productReviewList);

        return reviewDtoList;
    }


    @GetMapping("/{id}")
    public List<UserReviewDto> finds(@PathVariable Long id) {

        List<ProductReview> productReviewList = reviewManager.findAllUserReviewList(id);

        List<UserReviewDto> reviewDtoList = ReviewConverter.INSTANCE.convertAllProductReviewListToUserReviewDtoList(productReviewList);

        return reviewDtoList;
    }

    @GetMapping("/product/{id}")
    public List<ProductReviewDto> finds2(@PathVariable Long id) {
        List<ProductReview> productReviewList = reviewManager.findAllProductReviewList(id);

        List<ProductReviewDto> reviewDtoList = ReviewConverter.INSTANCE.convertAllProductReviewListToProductReviewDtoList(productReviewList);

        return reviewDtoList;
    }

}
