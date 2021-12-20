package com.burakyildiz.springboot.dataAccess.abstracts;

import com.burakyildiz.springboot.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
}
