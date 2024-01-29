package com.flyaway.flyaway.entity;

import com.flyaway.flyaway.domain.exception.ResourceNotFoundException;

import java.util.Arrays;

public enum Role {
    USER("USER"),
    ADMIN("ADMIN");

    private String value;

    Role(String value){
        this.value = value;
    }

    public static Role fromValue(String value){
        return Arrays.asList(Role.values()).stream()
                .filter(role -> role.value.equals(value))
                .findFirst()
                .orElseThrow(()-> new ResourceNotFoundException("Role not found"));
    }
}
