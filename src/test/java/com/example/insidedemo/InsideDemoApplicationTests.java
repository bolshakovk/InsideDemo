package com.example.insidedemo;

import com.example.insidedemo.controller.AuthController;
import com.example.insidedemo.controller.UserController;
import com.example.insidedemo.dto.UserPostDto;
import com.example.insidedemo.entity.UserEntity;
import com.example.insidedemo.repository.UserRepository;
import com.example.insidedemo.service.UserService;
import com.google.common.net.MediaType;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class InsideDemoApplicationTests {

    @Autowired
    AuthController authController;

    @Autowired
    UserController userController;

    @Mock
    MockMvc mockMvc;

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public List<UserEntity> getAllUser(){return userRepository.findAll();}

    @Test
    void getAllDataSuccess() throws Exception{
        UserEntity userEntity1 = new UserEntity( "username",
                "$2a$10$F/PyXb1lu4q3pel1t/uQgO9Kjo0UnfOZoY8W33KMlbRGvK1F/1qv2",
                "user_role");
        UserEntity userEntity2 = new UserEntity("username4",
                "$2a$10$R1moZB95PcffctLopiOXLuZBOypqhha7fmGsvviGcEBg/9B09KOg.",
                "user_role");
        UserEntity userEntit3 = new UserEntity("inside",
                "$2a$10$tU9AkmPOOCbeUxLqWjndHuH0LvZuhbWO5LUvpQymbjExhquYaqu5C",
                "user_role");
        List<UserEntity> userEntityList =new ArrayList<>(Arrays.asList(userEntity1, userEntity2, userEntit3));
        assertThat((userEntityList).size() == userRepository.findAll().size());
    }

    @Test
    void isUserControllerNotNull() throws Exception{
        assertThat(userController).isNotNull();
    }

    @Test
    void isAuthNotNull() throws Exception{
        assertThat(authController).isNotNull();
    }

}
