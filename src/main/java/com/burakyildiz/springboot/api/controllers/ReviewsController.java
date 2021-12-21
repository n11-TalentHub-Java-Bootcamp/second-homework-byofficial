package com.burakyildiz.springboot.api.controllers;

import com.burakyildiz.springboot.business.concretes.ProductManager;
import com.burakyildiz.springboot.business.concretes.ReviewManager;
import com.burakyildiz.springboot.business.concretes.UserManager;
import com.burakyildiz.springboot.business.exceptions.products.ProductNotFoundException;
import com.burakyildiz.springboot.business.exceptions.reviews.ReviewNotFoundException;
import com.burakyildiz.springboot.business.exceptions.users.UserNotFoundException;
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

    //[GET] https://localhost:8080/api/reviews/
    @GetMapping("")
    public List<ReviewDto> findAll() {
        List<ProductReview> productReviewList = reviewManager.findAll();

        //Sistemde hiç yorum yoksa
        if (productReviewList.size() == 0) {
            throw new ReviewNotFoundException("There are no review!");
        }

        List<ReviewDto> reviewDtoList = ReviewMapper.INSTANCE.convertAllReviewListToReviewDtoList(productReviewList);

        return reviewDtoList;
    }

    //[GET] https://localhost:8080/api/reviews/user/{id}
    @GetMapping("/user/{id}")
    public List<UserReviewDto> findAllUserReviewsList(@PathVariable Long id) {

        List<ProductReview> productReviewList = reviewManager.findAllUserReviewList(id);
        User user = userManager.findById(id);

        List<UserReviewDto> reviewDtoList = ReviewMapper.INSTANCE.convertAllProductReviewListToUserReviewDtoList(productReviewList);

        //Belirtilen kullanıcı varsa
        if (user != null) {
            //Kullanıcı yorum yapmadıysa
            if (reviewDtoList.size() == 0) {
                throw new ReviewNotFoundException(user.getFirstName() + " " + user.getLastName() +
                        " Kullanıcı henüz bir yorum yazmamıştır");
            }
        } else {
            throw new UserNotFoundException("User not found. id: " + id);
        }

        return reviewDtoList;
    }

    //[GET] https://localhost:8080/api/reviews/product/{id}
    @GetMapping("/product/{id}")
    public List<ProductReviewDto> findAllProductReviewsList(@PathVariable Long id) {
        Product product = productManager.findById(id);
        List<ProductReview> productReviewList = reviewManager.findAllProductReviewList(id);

        List<ProductReviewDto> reviewDtoList = ReviewMapper.INSTANCE.convertAllProductReviewListToProductReviewDtoList(productReviewList);

        //Belirtilen ürün varsa
        if (product != null) {
            //Ürüne yorum yapılmadıysa
            if (reviewDtoList.size() == 0) {
                throw new ReviewNotFoundException(product.getProductName() +
                        " adlı ürüne henüz bir yorum yazmamıştır");
            }
        } else {
            throw new ProductNotFoundException("Product not found. id: " + id);
        }

        return reviewDtoList;
    }

    //[POST] https://localhost:8080/api/reviews/
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

    //[DELETE] https://localhost:8080/api/reviews/{id}
    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable Long id) {
        ProductReview review = reviewManager.findById(id);

        //Belirtilen id ait yorum sistemde yoksa
        if (review == null) {
            throw new ReviewNotFoundException("Review not found. id: " + id);
        }

        reviewManager.deleteById(id);
    }

}
