package com.burakyildiz.springboot.entities.dtos;

import java.math.BigDecimal;
import java.util.Date;

public class ProductReviewDto implements IDto{

    //Ürün Adı
    private String productName;

    //Kategori Adı
    private String categoryName;

    //Ürün Fiyatı
    private BigDecimal productPrice;

    //Kullanıcı Adı
    private String userFirstName;

    //Kullanıcı Soyadı
    private String userLastName;

    //Kullanıcı Telefon
    private String userPhone;

    //Yorum
    private String review;

    //Yorum Tarihi
    private Date reviewDate;

    public ProductReviewDto() {
    }

    public ProductReviewDto(String productName, String categoryName, BigDecimal productPrice, String userFirstName, String userLastName, String userPhone, String review, Date reviewDate) {
        this.productName = productName;
        this.categoryName = categoryName;
        this.productPrice = productPrice;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userPhone = userPhone;
        this.review = review;
        this.reviewDate = reviewDate;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
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

