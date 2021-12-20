package com.burakyildiz.springboot.entities.dtos;

import java.math.BigDecimal;

public class ProductDetailDto implements IDto{

    //Ürün Adı
    private String productName;

    //Kategori Adı
    private String categoryName;

    //Ürün Fiyatı
    private BigDecimal productPrice;

    public ProductDetailDto() {
    }

    public ProductDetailDto(String productName, String categoryName, BigDecimal productPrice) {
        this.productName = productName;
        this.categoryName = categoryName;
        this.productPrice = productPrice;
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
}