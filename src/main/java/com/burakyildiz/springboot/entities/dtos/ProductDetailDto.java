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

    @Override
    public String toString() {
        return "ProductDetailDto{" +
                "productName='" + productName + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", productPrice=" + productPrice +
                '}';
    }
}