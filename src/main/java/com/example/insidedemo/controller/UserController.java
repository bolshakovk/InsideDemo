package com.example.insidedemo.controller;

import com.example.insidedemo.dto.UserPostDto;
import com.example.insidedemo.service.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//DEPRECATED!!!!!!!!!!!!!!!!!
@Controller
@RequestMapping("/inside")
@Api(value = "апи для работы без спринг секьюрити DEPRECATED")
public class UserController {
    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    @ApiOperation("создание юзера")
    public ResponseEntity<Void> create(@RequestBody UserPostDto userDto){
        userService.insertUser(userDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/{name}")
    @ApiOperation("получить пользака по имени")
    public ResponseEntity<Void> getByName(@PathVariable(value = "name") String name){
        userService.getUserByName(name);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    @ApiOperation("получить всех пользаков")
    public ResponseEntity<Void> getAll(){
        userService.getUsers();
        System.out.println(userService.getUsers().toString());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
