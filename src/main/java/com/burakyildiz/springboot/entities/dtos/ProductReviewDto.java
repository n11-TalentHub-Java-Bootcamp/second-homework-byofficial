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
    private Date reportDate;

    public ProductReviewDto() {
    }

    public ProductReviewDto(String productName, String categoryName, BigDecimal productPrice, String userFirstName, String userLastName, String userPhone, String review, Date reportDate) {
        this.productName = productName;
        this.categoryName = categoryName;
        this.productPrice = productPrice;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userPhone = userPhone;
        this.review = review;
        this.reportDate = reportDate;
    }

    @Override
    public String toString() {
        return "ProductReviewDto{" +
                "productName='" + productName + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", productPrice=" + productPrice +
                ", userFirstName='" + userFirstName + '\'' +
                ", userLastName='" + userLastName + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", review='" + review + '\'' +
                ", reportDate=" + reportDate +
                '}';
    }
}

