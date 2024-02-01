package com.flyaway.flyaway.domain.dto;

import javax.validation.constraints.*;


public class RegisterForm {

    private Integer id;
    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",message = "Oops! email already taken!")
    private String email;
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$",message = "Password not valid")
    private String password;
    @NotEmpty
    @Size(max = 30,message = "Maximum size of firstname is 30")
    private String name;
    @NotNull
    @Size(max = 30,message = "Maximum size of lastname is 30")
    private String lastname;

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

}
