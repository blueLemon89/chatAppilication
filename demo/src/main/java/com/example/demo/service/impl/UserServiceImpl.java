package com.example.demo.service.impl;

import com.example.demo.entity.UserEntity;
import com.example.demo.repo.UserRepo;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

//    @Override
//    public UserEntity registerUser(UserEntity user) {
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        return userRepo.save(user);
//    }

    @Override
    public Optional<UserEntity> findByUserName(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public Optional<UserEntity> findById(Long id) {
        return userRepo.findById(id);
    }

    @Override
    public void registerUser(UserEntity user) {
        Optional<UserEntity> existingUserByUsername = userRepo.findByUsername(user.getUsername());
        if (existingUserByUsername.isPresent()) {
            throw new IllegalArgumentException("Username is already taken");
        }

        Optional<UserEntity> existingUserByEmail = userRepo.findByEmail(user.getEmail());
        if (existingUserByEmail.isPresent()) {
            throw new IllegalArgumentException("Email is already registered");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.save(user);
    }
}
