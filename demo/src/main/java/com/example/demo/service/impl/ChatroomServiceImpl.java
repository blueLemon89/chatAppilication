package com.example.demo.service.impl;

import com.example.demo.DTO.ChatRoomDTO;
import com.example.demo.DTO.UserDTO;
import com.example.demo.entity.ChatroomEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.repo.ChatroomRepo;
import com.example.demo.repo.UserRepo;
import com.example.demo.service.ChatroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ChatroomServiceImpl implements ChatroomService {

    @Autowired
    ChatroomRepo chatRoomRepo;

    @Autowired
    UserRepo userRepo;

    @Override
    public ChatroomEntity createChatRoom(String name, UserDTO creator) {
        ChatroomEntity chatRoom = new ChatroomEntity();
        Optional<UserEntity> user =userRepo.findByUsername(creator.getUsername());
        chatRoom.setName(name);
        chatRoom.setUpdatedAt(Timestamp.valueOf(LocalDateTime.now().withNano(0)));
        chatRoom.setCreatedAt(Timestamp.valueOf(LocalDateTime.now().withNano(0)));
        chatRoom.getMembers().add(user.get());
        return chatRoomRepo.save(chatRoom);
    }

    @Override
    public List<ChatroomEntity> allChatRooms() {
        return chatRoomRepo.findAll();
    }

    @Override
    public List<ChatRoomDTO> getChatRoomsByCreator() {
        return chatRoomRepo.findByLoggedUserId(getLoggedInUserId());
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
