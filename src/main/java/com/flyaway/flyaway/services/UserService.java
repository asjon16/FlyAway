package com.flyaway.flyaway.services;

import com.flyaway.flyaway.domain.dto.PasswordChanger;
import com.flyaway.flyaway.domain.dto.RegisterForm;
import com.flyaway.flyaway.domain.dto.UserDto;
import com.flyaway.flyaway.entity.User;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

public interface UserService {
    UserDto registerDetails(@Valid RegisterForm registerForm);
    User findByID (Long Id);
    List <UserDto> findByName(String firstName, String lastName);
    List<UserDto> findAll();
    void changePassword(PasswordChanger passwordChanger);

}
