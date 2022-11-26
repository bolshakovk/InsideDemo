package com.example.insidedemo.mapper;

import com.example.insidedemo.dto.MessageDto;
import com.example.insidedemo.dto.UserPostDto;
import com.example.insidedemo.entity.MessageEntity;
import com.example.insidedemo.entity.UserEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//имплементация
@Component
public class MapStructMapperImpl implements MapStructMapper{
    @Override
    public UserPostDto userToDto(UserEntity user) {
        if (user == null){
            return null;
        }
        UserPostDto userPostDto = new UserPostDto();
        userPostDto.setId(user.getId());
        userPostDto.setName(user.getName());
        userPostDto.setPassword(user.getPassword());
        return userPostDto;
    }

    @Override
    public UserEntity userDtoToUser(UserPostDto userPostDto) {
        if (userPostDto == null){
            return null;
        }
        UserEntity user = new UserEntity();
        user.setId(userPostDto.getId());
        user.setName(userPostDto.getName());
        user.setPassword(userPostDto.getPassword());
        return user;
    }

    @Override
    public List<UserEntity> listUserToUserDto(List<UserEntity> all) {
        List<UserEntity> userEntities = new ArrayList<>(all);
        return userEntities;
    }

    @Override
    public MessageEntity messageDtoToMesaage(MessageDto messageDto) {
        if (messageDto == null){
            return null;
        }
        MessageEntity message = new MessageEntity();
        message.setMessage_id(messageDto.getId());
        message.setMessage(messageDto.getMessage());
        return message;
    }

}
