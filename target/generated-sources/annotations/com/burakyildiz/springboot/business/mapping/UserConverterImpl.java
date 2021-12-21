package com.burakyildiz.springboot.business.mapping;

import com.burakyildiz.springboot.entities.concretes.User;
import com.burakyildiz.springboot.entities.dtos.UserDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-21T10:24:30+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
public class UserConverterImpl implements UserConverter {

    @Override
    public List<UserDto> convertAllUserListToUserDtoList(List<User> userList) {
        if ( userList == null ) {
            return null;
        }

        List<UserDto> list = new ArrayList<UserDto>( userList.size() );
        for ( User user : userList ) {
            list.add( convertUserToUserDto( user ) );
        }

        return list;
    }

    @Override
    public User convertUserDtoToUser(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User user = new User();

        user.setPhoneNumber( userDto.getPhoneNumber() );
        user.setEmail( userDto.getEmail() );
        user.setId( userDto.getId() );
        user.setFirstName( userDto.getFirstName() );
        user.setLastName( userDto.getLastName() );
        user.setUserName( userDto.getUserName() );

        return user;
    }

    @Override
    public UserDto convertUserToUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setPhoneNumber( user.getPhoneNumber() );
        userDto.setEmail( user.getEmail() );
        userDto.setId( user.getId() );
        userDto.setFirstName( user.getFirstName() );
        userDto.setLastName( user.getLastName() );
        userDto.setUserName( user.getUserName() );

        return userDto;
    }
}
