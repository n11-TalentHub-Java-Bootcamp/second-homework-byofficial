package com.burakyildiz.springboot.dataAccess.abstracts;

import com.burakyildiz.springboot.entities.concretes.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDao extends JpaRepository<Category, Long> {

}
