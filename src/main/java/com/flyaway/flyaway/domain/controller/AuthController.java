package com.flyaway.flyaway.domain.controller;

import com.flyaway.flyaway.configuration.AuthService;
import com.flyaway.flyaway.domain.dto.LoginRequestDto;
import com.flyaway.flyaway.domain.dto.RegisterForm;
import com.flyaway.flyaway.domain.dto.UserDto;
import com.flyaway.flyaway.services.UserService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Controller
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authentication;
    private final UserService userService;

    public AuthController(AuthService authentication, UserService userService) {
        this.authentication = authentication;
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<String>token(@RequestBody LoginRequestDto req){
        String token = authentication.generateToken(req);

        if (token!=null){
            return ResponseEntity.ok("Bearer "+ token);
        }else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody @Valid RegisterForm user, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResponseEntity.badRequest().build();
        }
        UserDto registeredUser = userService.registerDetails(user);
        if (registeredUser!=null){
            return ResponseEntity.ok(registeredUser);
        }else{
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }


    }


}
