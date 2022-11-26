package com.example.insidedemo.service;

import com.example.insidedemo.dto.UserPostDto;
import com.example.insidedemo.entity.UserEntity;

import java.util.List;

public interface UserService {
    void insertUser(UserPostDto user);
    void getUserByName(String name);
    List<UserEntity> getUsers();
    boolean isUserExist(String name);
}
