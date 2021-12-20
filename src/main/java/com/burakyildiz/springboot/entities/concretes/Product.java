package com.burakyildiz.springboot.entities.concretes;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="PRODUCT")
public class Product implements IEntity{
    @SequenceGenerator(name = "generator", sequenceName = "PRODUCT_ID_SEQ")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "ID", nullable = false)
    private Long id;

    //Adı
    @Column(name="NAME", length = 50)
    private String productName;

    //Fiyat
    @Column(name="PRICE", precision = 19, scale = 2)
    private BigDecimal price;

    //Kayıt Tarihi
    @Column(name = "CREATED_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    //Kategori
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CATEGORY", foreignKey = @ForeignKey(name = "FK_PRODUCT_CATEGORY_ID"))
    private Category category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return id == null ? "" : id.toString();
    }
}
