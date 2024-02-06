package com.flyaway.flyaway.domain.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.Pattern;

@Data
@RequiredArgsConstructor
public class PasswordChanger {

    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$",message = "Password not valid")
    private String oldPassword;
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$",message = "Password not valid")
    private String newPassword;
}
