package com.burakyildiz.springboot.api.controllers;

import com.burakyildiz.springboot.business.concretes.ProductManager;
import com.burakyildiz.springboot.business.concretes.ReviewManager;
import com.burakyildiz.springboot.business.concretes.UserManager;
import com.burakyildiz.springboot.business.exceptions.ProductNotFoundException;
import com.burakyildiz.springboot.business.exceptions.ReviewNotFoundException;
import com.burakyildiz.springboot.business.exceptions.UserNotFoundException;
import com.burakyildiz.springboot.business.mapping.ReviewMapper;
import com.burakyildiz.springboot.entities.concretes.Product;
import com.burakyildiz.springboot.entities.concretes.ProductReview;
import com.burakyildiz.springboot.entities.concretes.User;
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

    @Autowired
    private UserManager userManager;

    @Autowired
    private ProductManager productManager;

    @GetMapping("")
    public List<ReviewDto> findAll() {
        List<ProductReview> productReviewList = reviewManager.findAll();

        List<ReviewDto> reviewDtoList = ReviewMapper.INSTANCE.convertAllReviewListToReviewDtoList(productReviewList);

        return reviewDtoList;
    }


    @GetMapping("/user/{id}")
    public List<UserReviewDto> findAllUserReviewsList(@PathVariable Long id) {

        List<ProductReview> productReviewList = reviewManager.findAllUserReviewList(id);
        User user = userManager.findById(id);

        List<UserReviewDto> reviewDtoList = ReviewMapper.INSTANCE.convertAllProductReviewListToUserReviewDtoList(productReviewList);

        if (user != null) {
            if (reviewDtoList.size() == 0) {
                throw new ReviewNotFoundException(user.getFirstName() + " " + user.getLastName() +
                        " Kullanıcı henüz bir yorum yazmamıştır");
            }
        } else {
            throw new UserNotFoundException("User not found. id: " + id);
        }

        return reviewDtoList;
    }

    @GetMapping("/product/{id}")
    public List<ProductReviewDto> findAllProductReviewsList(@PathVariable Long id) {
        Product product = productManager.findById(id);
        List<ProductReview> productReviewList = reviewManager.findAllProductReviewList(id);

        List<ProductReviewDto> reviewDtoList = ReviewMapper.INSTANCE.convertAllProductReviewListToProductReviewDtoList(productReviewList);

        if (product != null) {
            if (reviewDtoList.size() == 0) {
                throw new ReviewNotFoundException(product.getProductName() +
                        " adlı ürüne henüz bir yorum yazmamıştır");
            }
        } else {
            throw new ProductNotFoundException("Product not found. id: " + id);
        }


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
