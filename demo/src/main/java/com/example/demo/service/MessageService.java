package com.example.demo.service;

import com.example.demo.entity.ChatroomEntity;
import com.example.demo.entity.MessageEntity;
import com.example.demo.entity.UserEntity;

public interface MessageService {

    MessageEntity sendMessage(ChatroomEntity chatroomEntity, UserEntity sender, String message);
}
