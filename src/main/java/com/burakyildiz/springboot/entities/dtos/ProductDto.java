package com.burakyildiz.springboot.entities.dtos;

import com.fasterxml.jackson.annotation.JsonFilter;

import java.math.BigDecimal;
import java.util.Date;

@JsonFilter("ProductDtoFilter")
public class ProductDto implements IDto{
    private Long id;
    private String name;
    private BigDecimal price;
    private Date createdAt;
    private Long categoryId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
