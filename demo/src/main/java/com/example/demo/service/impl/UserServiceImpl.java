package com.example.demo.service.impl;

import com.example.demo.entity.UserEntity;
import com.example.demo.repo.UserRepo;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserEntity registerUser(UserEntity user) {
        return userRepo.save(user);
    }

    @Override
    public Optional<UserEntity> findByUserName(Long userId) {
        return userRepo.findById(userId);
    }
}
