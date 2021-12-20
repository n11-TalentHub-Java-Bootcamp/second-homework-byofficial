package com.burakyildiz.springboot.entities.dtos;

import java.math.BigDecimal;

public class ProductReviewCountDto implements IDto{

    //Ürün Id
    private Long productId;

    //Ürün Adı
    private String productName;

    //Fiyat
    private BigDecimal price;

    //Yorum Sayısı
    private Long reviewCount;

    public ProductReviewCountDto() {
    }

    public ProductReviewCountDto(Long productId, String productName, BigDecimal price, Long reviewCount) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.reviewCount = reviewCount;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(Long reviewCount) {
        this.reviewCount = reviewCount;
    }

    @Override
    public String toString() {
        return "ProductReviewCountDto{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", reviewCount=" + reviewCount +
                '}';
    }
}
