package com.example.demo.service;

import com.example.demo.entity.UserEntity;

import java.util.Optional;

public interface UserService {

//    UserEntity registerUser(UserEntity user);

    Optional<UserEntity> findByUserName(String username);

    Optional<UserEntity> findById(Long userId);

    void registerUser(UserEntity user);
}
