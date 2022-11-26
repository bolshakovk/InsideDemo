package com.example.insidedemo.jwt.payload.request;

import javax.validation.constraints.NotBlank;

//запрос логина
public class LoginRequest {
    private String username;

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

}
