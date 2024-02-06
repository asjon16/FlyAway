package com.flyaway.flyaway.domain.controller;

import com.flyaway.flyaway.domain.dto.PasswordChanger;
import com.flyaway.flyaway.domain.dto.UserDto;
import com.flyaway.flyaway.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.flyaway.flyaway.domain.mapper.UserMapper.toDto;

@Controller
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

   private final UserService userService;

    @GetMapping("/all")
    public ResponseEntity <List<UserDto>> findAll(){
        return ResponseEntity.ok((userService.findAll()));
    }

    @GetMapping("{id}")
    public ResponseEntity <UserDto> findById(@PathVariable Long id){
        return ResponseEntity.ok(toDto(userService.findByID(id)));
    }

    @GetMapping ("/findName")
    public ResponseEntity<List<UserDto>> findUserWithNameAndLastName(@RequestBody UserDto userDto){
        return ResponseEntity.ok(userService.findByName(userDto.getName(), userDto.getLastName()));
    }

    @PostMapping("/password")
    public ResponseEntity<Void>changePassword(@RequestBody PasswordChanger passwordChanger){
        userService.changePassword(passwordChanger);
        return new ResponseEntity<>(HttpStatus.OK);
    }






}
