package com.burakyildiz.springboot.dataAccess.abstracts;

import com.burakyildiz.springboot.entities.concretes.Product;
import com.burakyildiz.springboot.entities.concretes.ProductReview;
import com.burakyildiz.springboot.entities.dtos.ProductReviewDto;
import com.burakyildiz.springboot.entities.dtos.UserReviewDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewDao extends JpaRepository<ProductReview, Long> {
    @Query("select " +
            "review from ProductReview review " +
            "left join User user on user.id = review.userId.id " +
            "left join Product product on product.id = review.productId.id " +
            "where review.userId.id= :userId")
    List<ProductReview> findAllUserReviewList(Long userId);

    @Query("select " +
            "review from ProductReview review " +
            "left join User user on user.id = review.userId.id " +
            "left join Product product on product.id = review.productId.id " +
            "where review.productId.id= :productId")
    List<ProductReview> findAllProductReviewList(Long productId);


}
