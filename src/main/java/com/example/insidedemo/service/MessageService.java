package com.example.insidedemo.service;

import com.example.insidedemo.dto.MessageDto;
import com.example.insidedemo.entity.MessageEntity;

import java.util.List;

public interface MessageService {
    List<MessageEntity> findLast();
    void addMessage(MessageDto messageDto);
}
