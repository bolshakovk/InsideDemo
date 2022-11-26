package com.example.insidedemo.mapper;

import com.example.insidedemo.dto.MessageDto;
import com.example.insidedemo.dto.UserPostDto;
import com.example.insidedemo.entity.MessageEntity;
import com.example.insidedemo.entity.UserEntity;
import org.mapstruct.Mapper;

import java.util.List;

//Мапить модели
@Mapper(componentModel = "spring")
public interface MapStructMapper {
    UserPostDto userToDto(UserEntity user);
    UserEntity userDtoToUser(UserPostDto userPostDto);
    List<UserEntity> listUserToUserDto(List<UserEntity> all);
    MessageEntity messageDtoToMesaage(MessageDto messageDto);
}
