package com.example.demo.controller;


import com.example.demo.entity.ChatroomEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.service.ChatroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class ChatRoomController {
    @Autowired
    private ChatroomService chatroomService;

    @PostMapping("/chatrooms")
    public ResponseEntity<ChatroomEntity> createChatRoom(@RequestParam String name, @RequestBody UserEntity creator) {
        return ResponseEntity.ok(chatroomService.createChatRoom(name, creator));
    }

}
