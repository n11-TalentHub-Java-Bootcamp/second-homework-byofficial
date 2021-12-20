package com.burakyildiz.springboot.entities.concretes;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="PRODUCT_REVIEW")
public class ProductReview implements IEntity {
    @SequenceGenerator(name = "generator", sequenceName = "PRODUCT_REVIEW_ID_SEQ")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "ID", nullable = false)
    private Long id;

    //Yorum
    @Column(name = "REVIEW", length = 500)
    private String review;

    //Yorum Tarihi
    @Column(name = "REVIEW_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reviewDate;

    //ÜrünId
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PRODUCT",
            foreignKey = @ForeignKey(name = "FK_PRODUCT_REVIEW_PRODUCT_ID")
    )
    private Product productId;

    //KullaniciId
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USER",
            foreignKey = @ForeignKey(name = "FK_PRODUCT_REVIEW_USER_ID")
    )
    private User userId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return id == null ? "" : id.toString();
    }
}
