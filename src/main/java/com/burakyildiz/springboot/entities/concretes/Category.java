package com.burakyildiz.springboot.entities.concretes;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="CATEGORY")
public class Category implements IEntity, Serializable {
    @SequenceGenerator(name = "generator", sequenceName = "KATEGORI_ID_SEQ")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "ID", nullable = false)
    private Long id;

    //Kategori Adı
    @Column(name="NAME", nullable = false, length = 50)
    private String categoryName;

    //Kırılım
    @Column(name="LEVEL")
    private Long level;

    //Üst Kategori
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_TOP_CATEGORY")
    private Category topCategory;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Long getLevel() {
        return level;
    }

    public void setLevel(Long level) {
        this.level = level;
    }

    public Category getTopCategory() {
        return topCategory;
    }

    public void setTopCategory(Category topCategory) {
        this.topCategory = topCategory;
    }

    @Override
    public String toString() {
        return id == null ? "" : id.toString();
    }
}
