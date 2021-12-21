package com.burakyildiz.springboot.business.concretes;

import com.burakyildiz.springboot.business.abstracts.IUserService;
import com.burakyildiz.springboot.dataAccess.abstracts.UserDao;
import com.burakyildiz.springboot.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserManager implements IUserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findById(Long id) {
        Optional<User> optionalUser = userDao.findById(id);

        User user = null;
        if (optionalUser.isPresent()) {
            user = optionalUser.get();
        }

        return user;
    }

    @Override
    public User save(User user) {
        return userDao.save(user);
    }

    @Override
    public void delete(User user) {
        userDao.delete(user);
    }

    @Override
    public void deleteById(Long id) {
        userDao.deleteById(id);
    }

    @Override
    public long count() {
        return userDao.count();
    }


    //Kullanıcı adı ve telefon bilgilerini kullanarak kullanıcıyı bulmak
    public User findByUserNameAndPhoneNumber(String name, String phone) {
        return userDao.findByUserNameAndPhoneNumber(name, phone);
    }

    //Kullanıcı adı veya telefon bilgilerini kullanarak kullanıcıyı bulmak
    public User findByUserNameOrPhoneNumber(String name, String phone) {
        return userDao.findByUserNameOrPhoneNumber(name, phone);
    }

    //Kullanıcı adı bilgisini kullanarak kullanıcıyı bulmak
    public User findByUserName(String name) {
        return userDao.findByUserName(name);
    }

    //Telefon bilgisini kullanarak kullanıcıyı bulmak
    public User findByPhoneNumber(String phone) {
        return userDao.findByPhoneNumber(phone);
    }


    public void deleteByUser(String name, String phone) {
        userDao.deletedByUser(name, phone);
    }

}
