package com.burakyildiz.springboot.business.mapping;


import com.burakyildiz.springboot.entities.concretes.Category;
import com.burakyildiz.springboot.entities.concretes.User;
import com.burakyildiz.springboot.entities.dtos.CategoryDto;
import com.burakyildiz.springboot.entities.dtos.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserConverter {
    UserConverter INSTANCE = Mappers.getMapper(UserConverter.class);

    List<UserDto> convertAllUserListToUserDtoList(List<User> userList);

    @Mapping(source = "phoneNumber", target = "phoneNumber")
    @Mapping(source = "email", target = "email")
    User convertUserDtoToUser(UserDto userDto);

    @Mapping(source = "phoneNumber", target = "phoneNumber")
    @Mapping(source = "email", target = "email")
    UserDto convertUserToUserDto(User user);


}
