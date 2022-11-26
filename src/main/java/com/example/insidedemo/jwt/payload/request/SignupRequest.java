package com.example.insidedemo.jwt.payload.request;

import javax.validation.constraints.*;

//запрос регистрации
public class SignupRequest {
    @NotBlank
    @Size(min = 3, max = 20)
    private String username;

    String role = "user_role";

    @NotBlank
    @Size(min = 3, max = 20)
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return this.role;
    }

}
