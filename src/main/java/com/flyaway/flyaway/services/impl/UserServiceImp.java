package com.flyaway.flyaway.services.impl;

import com.flyaway.flyaway.domain.dto.RegisterForm;
import com.flyaway.flyaway.domain.dto.UserDto;
import com.flyaway.flyaway.entity.Role;
import com.flyaway.flyaway.entity.User;
import com.flyaway.flyaway.repository.UserRepository;
import com.flyaway.flyaway.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.flyaway.flyaway.domain.mapper.UserMapper.toDto;

@RequiredArgsConstructor
@Service
public class UserServiceImp implements UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;



    @Override
    public UserDto registerDetails(RegisterForm registerForm) {
        var user = new User();
        user.setName(registerForm.getName());
        user.setLastName(registerForm.getLastname());
        user.setEmail(registerForm.getEmail());
        user.setRole(Role.USER);
        user.setPassword(passwordEncoder.encode(registerForm.getPassword()));
        return toDto(userRepository.save(user));
    }
}
