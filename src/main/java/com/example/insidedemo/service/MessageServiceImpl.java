package com.example.insidedemo.service;

import com.example.insidedemo.dto.MessageDto;
import com.example.insidedemo.entity.MessageEntity;
import com.example.insidedemo.mapper.MapStructMapperImpl;
import com.example.insidedemo.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;

    private final MapStructMapperImpl mapper;

    public MessageServiceImpl(MessageRepository messageRepository, MapStructMapperImpl mapper) {
        this.messageRepository = messageRepository;
        this.mapper = mapper;
    }

    @Override
    public List<MessageEntity> findLast() {
        return messageRepository.findLastTen();
    }

    @Override
    public void addMessage(MessageDto messageDto) {
        messageRepository.save(mapper.messageDtoToMesaage(messageDto));
    }
}
