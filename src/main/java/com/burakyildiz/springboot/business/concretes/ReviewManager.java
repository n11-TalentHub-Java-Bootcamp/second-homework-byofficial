package com.burakyildiz.springboot.business.concretes;

import com.burakyildiz.springboot.business.abstracts.IReviewService;
import com.burakyildiz.springboot.dataAccess.abstracts.ReviewDao;
import com.burakyildiz.springboot.entities.concretes.ProductReview;
import com.burakyildiz.springboot.entities.dtos.ProductReviewDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewManager implements IReviewService {
    @Autowired
    private ReviewDao reviewDao;

    @Override
    public List<ProductReview> findAll() {
        return reviewDao.findAll();
    }

    @Override
    public ProductReview findById(Long id) {
        Optional<ProductReview> optionalProductReview = reviewDao.findById(id);

        ProductReview productReview = null;
        if (optionalProductReview.isPresent()) {
            productReview = optionalProductReview.get();
        }

        return productReview;
    }

    @Override
    public ProductReview save(ProductReview productReview) {
        return reviewDao.save(productReview);
    }

    @Override
    public void delete(ProductReview productReview) {
        reviewDao.delete(productReview);
    }

    @Override
    public void deleteById(Long id) {
        reviewDao.deleteById(id);
    }

    @Override
    public long count() {
        return reviewDao.count();
    }

    public List<ProductReview> findAllUserReviewList(Long userId) {
        return reviewDao.findAllUserReviewList(userId);
    }

    public List<ProductReview> findAllProductReviewList(Long productId){
        return reviewDao.findAllProductReviewList(productId);
    }
}
