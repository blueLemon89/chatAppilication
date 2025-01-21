package com.example.demo.controller;

import com.example.demo.entity.ChatroomEntity;
import com.example.demo.entity.MessageEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping("/messages")
    public ResponseEntity<MessageEntity> sendMessage(@RequestParam Long chatRoomId, @RequestParam Long userId, @RequestParam String content) {
        ChatroomEntity chatRoom = new ChatroomEntity();
        chatRoom.setId(chatRoomId);
        UserEntity sender = new UserEntity();
        sender.setId(userId);
        return ResponseEntity.ok(messageService.sendMessage(chatRoom, sender, content));
    }
}
