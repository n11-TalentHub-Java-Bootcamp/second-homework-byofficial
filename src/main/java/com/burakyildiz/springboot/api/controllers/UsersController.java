package com.burakyildiz.springboot.api.controllers;

import com.burakyildiz.springboot.business.concretes.UserManager;
import com.burakyildiz.springboot.business.mapping.UserMapper;
import com.burakyildiz.springboot.entities.concretes.User;
import com.burakyildiz.springboot.entities.dtos.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {
    @Autowired
    private UserManager userManager;

    @GetMapping("")
    public List<UserDto> findAll() {

        List<User> userList = userManager.findAll();

        List<UserDto> userDtoList = UserMapper.INSTANCE.convertAllUserListToUserDtoList(userList);

        return userDtoList;
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {

        User user = userManager.findById(id);

        return user;
    }

    // Query = q
    @GetMapping("/q")
    public User findByNameOrPhone(@RequestParam(value = "name", required = false) String name,
                                  @RequestParam(value = "phone", required = false) String phone) {
        User getUser = null;

        if (name != null && phone == null) {
            getUser = userManager.findByUserName(name);

        } else if (phone != null && name == null) {
            getUser = userManager.findByPhoneNumber(phone);

        } else if (name != null && phone != null) {
            getUser = userManager.findByUserNameAndPhoneNumber(name, phone);
        }

        return getUser;
    }

    @PostMapping("")
    public ResponseEntity<Object> saveUser(@RequestBody UserDto userDto) {

        User user = UserMapper.INSTANCE.convertUserDtoToUser(userDto);

        user = userManager.save(user);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("")
    public ResponseEntity<String> deleteByUser(@RequestParam String name,
                                               @RequestParam String phone) {

        User getUser = userManager.findByUserNameOrPhoneNumber(name, phone);
        ResponseEntity<String> result = null;

        if (name != null && phone != null) {
            if (getUser != null) {
                userManager.deleteByUser(name, phone);
                result = new ResponseEntity<>("Kullanıcı başarıyla silindi!", HttpStatus.OK);
            } else {
                result = new ResponseEntity<>(
                        name + " kullanıcı adı ile " + phone + " telefonu bilgileri uyuşmamaktadır!",
                        HttpStatus.NOT_FOUND);
            }


        } else if (phone == null || name == null) {
            result = new ResponseEntity<>("Lütfen kullanıcı adı veya telefon bilgilerini girin",
                    HttpStatus.BAD_REQUEST);

        }

        return result;

    }

    @PutMapping("")
    public UserDto updateUser(@RequestBody UserDto userDto) {

        User user = UserMapper.INSTANCE.convertUserDtoToUser(userDto);

        user = userManager.save(user);

        UserDto userDtoResult = UserMapper.INSTANCE.convertUserToUserDto(user);

        return userDtoResult;
    }


}
