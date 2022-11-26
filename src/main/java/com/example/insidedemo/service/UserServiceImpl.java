package com.example.insidedemo.service;

import com.example.insidedemo.dto.UserPostDto;
import com.example.insidedemo.entity.UserEntity;
import com.example.insidedemo.mapper.MapStructMapperImpl;
import com.example.insidedemo.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    private final MapStructMapperImpl mapper;
    private final UserRepository userRepository;

    public UserServiceImpl(MapStructMapperImpl mapper, UserRepository userRepository) {
        this.mapper = mapper;
        this.userRepository = userRepository;
    }

    @Override
    public void insertUser(UserPostDto user) {
        userRepository.save(mapper.userDtoToUser(user));
    }

    @Override
    public void getUserByName(String name) {
        userRepository.findByName(name);
        System.out.println(userRepository.findByName(name));
    }



    @Override
    public List<UserEntity> getUsers() {
        return mapper.listUserToUserDto(userRepository.findAll());
    }

    @Override
    public boolean isUserExist(String name) {
        return userRepository.existsByUsername(name);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByName(username)
            .orElseThrow(()-> new UsernameNotFoundException("user not found with name: " + username));
        return UserDetailsImpl.build(user);
    }
}
