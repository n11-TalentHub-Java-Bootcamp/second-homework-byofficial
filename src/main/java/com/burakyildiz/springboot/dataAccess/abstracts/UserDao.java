package com.burakyildiz.springboot.dataAccess.abstracts;

import com.burakyildiz.springboot.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface UserDao extends JpaRepository<User, Long> {
    @Query("select user from User user where user.userName=:name and user.phoneNumber= :phone")
    User findByUserNameAndPhoneNumber(String name, String phone);

    @Query("select user from User user where user.userName=:name or user.phoneNumber= :phone")
    User findByUserNameOrPhoneNumber(String name, String phone);

    @Query("select user from User user where user.userName=:name")
    User findByUserName(String name);

    @Query("select user from User user where user.phoneNumber= :phone")
    User findByPhoneNumber(String phone);

    @Transactional
    @Modifying
    @Query("delete from User user where user.userName=:name and  user.phoneNumber=:phone")
    void deletedByUser(String name, String phone);
}
