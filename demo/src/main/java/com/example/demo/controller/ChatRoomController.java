package com.example.demo.controller;


import com.example.demo.DTO.ChatRoomDTO;
import com.example.demo.entity.ChatroomEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.service.ChatroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chatrooms")
public class ChatRoomController {
    @Autowired
    private ChatroomService chatroomService;

    @PostMapping("/create")
    public ResponseEntity<ChatroomEntity> createChatRoom(@RequestParam String name, @RequestBody UserEntity creator) {
        return ResponseEntity.ok(chatroomService.createChatRoom(name, creator));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ChatRoomDTO>> allChatRooms() {
        List<ChatRoomDTO> chatRooms = chatroomService.getChatRoomsByCreator();
        return ResponseEntity.ok(chatRooms);
    }

}
