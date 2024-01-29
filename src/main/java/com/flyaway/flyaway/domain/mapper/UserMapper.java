package com.flyaway.flyaway.domain.mapper;

import com.flyaway.flyaway.domain.dto.UserDto;
import com.flyaway.flyaway.entity.User;

public class UserMapper {
    public static User toEntity(UserDto u){
        var user = new User();
        user.setName(u.getName());
        user.setLastName(u.getLastName());
        user.setEmail(u.getEmail());
        user.setPassword(u.getPassword());
        return user;
    }

    public static UserDto toDto(User u){
        var userDto = new UserDto();
        userDto.setName(u.getName());
        userDto.setLastName(u.getLastName());
        userDto.setEmail(u.getEmail());
        userDto.setPassword(u.getPassword());
        return userDto;
    }
}
