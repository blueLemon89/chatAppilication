package com.example.demo.service.impl;

import com.example.demo.DTO.ChatRoomDTO;
import com.example.demo.entity.ChatroomEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.repo.ChatroomRepo;
import com.example.demo.service.ChatroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatroomServiceImpl implements ChatroomService {

    @Autowired
    ChatroomRepo chatRoomRepo;

    @Override
    public ChatroomEntity createChatRoom(String name, UserEntity creator) {
        ChatroomEntity chatRoom = new ChatroomEntity();
        chatRoom.setName(name);
        chatRoom.getMembers().add(creator);
        return chatRoomRepo.save(chatRoom);
    }

    @Override
    public List<ChatroomEntity> allChatRooms() {
        return chatRoomRepo.findAll();
    }

    @Override
    public List<ChatRoomDTO> getChatRoomsByCreator() {
        return chatRoomRepo.findByCreatorId(getLoggedInUserId());
    }

    private Long getLoggedInUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof UserEntity) {
            UserEntity user = (UserEntity) authentication.getPrincipal();
            return user.getId();
        }
        throw new IllegalStateException("User is not logged in");
    }
}
