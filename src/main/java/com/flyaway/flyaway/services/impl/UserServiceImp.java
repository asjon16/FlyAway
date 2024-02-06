package com.flyaway.flyaway.services.impl;

import com.flyaway.flyaway.configuration.SecurityUtils;
import com.flyaway.flyaway.domain.dto.PasswordChanger;
import com.flyaway.flyaway.domain.dto.RegisterForm;
import com.flyaway.flyaway.domain.dto.UserDto;
import com.flyaway.flyaway.domain.exception.AccessDeniedException;
import com.flyaway.flyaway.domain.exception.ResourceNotFoundException;
import com.flyaway.flyaway.domain.mapper.UserMapper;
import com.flyaway.flyaway.entity.Role;
import com.flyaway.flyaway.entity.User;
import com.flyaway.flyaway.repository.UserRepository;
import com.flyaway.flyaway.services.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public User findByID(Long id) {
       return userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(String
               .format("User with ID %s doesn't exist",id)));
    }

    @Override
    public List <UserDto> findByName(String firstName, String lastName) {
        return userRepository.findByNameOrLastNameContainingIgnoreCase(firstName,lastName).stream().map(UserMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll().stream().map(UserMapper::toDto).collect(Collectors.toList());
    }
    @Transactional
    public void changePassword(PasswordChanger passwordChanger){
        var auth = SecurityUtils.getLoggedUserId();
        var loggedUser = findByID(auth.longValue());
        if (!passwordEncoder.matches(passwordChanger.getOldPassword(), loggedUser.getPassword())) {
            throw new AccessDeniedException("Old password not correct");
        }
        if (passwordEncoder.matches(passwordChanger.getNewPassword(), loggedUser.getPassword())) {
            throw new AccessDeniedException("New password can't be the same as the old password");
        }else {
            loggedUser.setPassword(passwordEncoder.encode(passwordChanger.getNewPassword()));
            userRepository.save(loggedUser);
        }

    }

}
