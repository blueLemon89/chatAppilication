package com.example.demo.service.impl;

import com.example.demo.entity.ChatroomEntity;
import com.example.demo.entity.MessageEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.repo.MessageRepo;
import com.example.demo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageRepo messageRepo;

    @Override
    public MessageEntity sendMessage(ChatroomEntity chatroomEntity, UserEntity sender, String message) {
        MessageEntity content = new MessageEntity();
        content.setChatRoom(chatroomEntity);
        content.setSender(sender);
        content.setContent(message);
        return messageRepo.save(content);
    }
}
