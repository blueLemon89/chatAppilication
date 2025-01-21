package com.example.demo.service.impl;

import com.example.demo.entity.ChatroomEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.repo.ChatroomRepo;
import com.example.demo.service.ChatroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatroomServiceImpl implements ChatroomService {

    @Autowired
    ChatroomRepo chatroomRepo;

    public ChatroomEntity createChatRoom(String name, UserEntity creator) {
        ChatroomEntity chatRoom = new ChatroomEntity();
        chatRoom.setName(name);
        chatRoom.getMembers().add(creator);
        return chatroomRepo.save(chatRoom);
    }
}
