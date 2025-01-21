package com.example.demo.service;

import com.example.demo.entity.UserEntity;

import java.util.Optional;

public interface UserService {

    UserEntity registerUser(UserEntity user);

    Optional<UserEntity> findByUserName(Long userId);
}
