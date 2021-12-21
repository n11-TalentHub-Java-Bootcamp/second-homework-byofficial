package com.burakyildiz.springboot.entities.dtos;

import java.util.Date;

public class UserReviewDto implements IDto{
    //kullanıcıId


    //kullanıcı adı
    private String userFirstName;

    //ürün adı
    private String productName;

    //yorum
    private String review;

    //yorum tarihi
    private Date reviewDate;

    public UserReviewDto() {
    }

    public UserReviewDto(String userFirstName, String productName, String review, Date reviewDate) {
        this.userFirstName = userFirstName;
        this.productName = productName;
        this.review = review;
        this.reviewDate = reviewDate;
    }



    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }


}
