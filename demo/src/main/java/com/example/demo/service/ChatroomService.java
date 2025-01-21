package com.example.demo.service;

import com.example.demo.DTO.ChatRoomDTO;
import com.example.demo.entity.ChatroomEntity;
import com.example.demo.entity.UserEntity;

import java.util.List;

public interface ChatroomService {

    ChatroomEntity createChatRoom(String name, UserEntity creator);

    List<ChatroomEntity> allChatRooms();

    List<ChatRoomDTO> getChatRoomsByCreator();
}
