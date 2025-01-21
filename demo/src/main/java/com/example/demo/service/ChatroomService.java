package com.example.demo.service;

import com.example.demo.entity.ChatroomEntity;
import com.example.demo.entity.UserEntity;

public interface ChatroomService {

    ChatroomEntity createChatRoom(String name, UserEntity creator);
}
