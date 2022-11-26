package com.example.insidedemo.controller;

import javax.validation.Valid;

import com.example.insidedemo.dto.MessageDto;
import com.example.insidedemo.entity.MessageEntity;
import com.example.insidedemo.entity.UserEntity;
import com.example.insidedemo.jwt.JwtUtils;
import com.example.insidedemo.jwt.payload.request.LoginRequest;
import com.example.insidedemo.jwt.payload.request.MessageRequest;
import com.example.insidedemo.jwt.payload.request.SignupRequest;
import com.example.insidedemo.jwt.payload.response.JwtResponse;
import com.example.insidedemo.jwt.payload.response.MessageResponse;
import com.example.insidedemo.repository.UserRepository;
import com.example.insidedemo.service.MessageServiceImpl;
import com.example.insidedemo.service.UserDetailsImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//контроллер для работы с авторизацией, логином, мессенджем
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
@Api("API для работы с авторизацией и аутентификацией")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    MessageServiceImpl messageService;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/message")
    @ApiOperation(value = "пост запрос с пользователем и его сообщением")
    public ResponseEntity<?> listenerMessage(@Valid @RequestBody MessageDto messageDto){
        if (messageDto.getMessage().equals("history 10")){
            List<MessageEntity> list = messageService.findLast();
            for (MessageEntity item: list){
                System.out.println(item.toString());
            }
        }else {
            messageService.addMessage(messageDto);
        }

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/signin")
    @ApiOperation("Авторизация пользователя")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        String roles = userDetails.getRoles();
        System.out.println(new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(), userDetails.getPassword()).getAccessToken());
        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                roles));
    }

    @PostMapping("/signup")
    @ApiOperation(value = "создание пользователя и добавление его в бд, с генерацией JWT")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        // Create new user's account
        System.out.println(signUpRequest.getUsername() + " username");
        System.out.println(signUpRequest.getPassword() + " password");
        System.out.println(signUpRequest.getRole() + " roles");
        UserEntity user = new UserEntity(signUpRequest.getUsername(), encoder.encode(signUpRequest.getPassword()), signUpRequest.getRole());

        System.out.println("created: " + user);

        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
}
