package com.flyaway.flyaway.services.impl;

import com.flyaway.flyaway.domain.dto.RegisterForm;
import com.flyaway.flyaway.domain.dto.UserDto;
import com.flyaway.flyaway.entity.User;
import com.flyaway.flyaway.repository.UserRepository;
import com.flyaway.flyaway.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import static com.flyaway.flyaway.domain.mapper.UserMapper.toDto;

@RequiredArgsConstructor
public class UserServiceImp implements UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;



    @Override
    public UserDto registerDetails(RegisterForm registerForm) {
        var user = new User();
        user.setName(registerForm.getFirstname());
        user.setLastName(registerForm.getLastname());
        user.setEmail(registerForm.getEmail());
        user.setPassword(passwordEncoder.encode(registerForm.getPassword()));
        return toDto(userRepository.save(user));
    }
}
