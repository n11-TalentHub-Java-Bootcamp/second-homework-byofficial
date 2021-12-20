package com.burakyildiz.springboot.business.abstracts;

import com.burakyildiz.springboot.entities.concretes.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findById(Long id);

    User save(User user);

    void delete(User user);

    void deleteById(Long id);

    long count();
}
