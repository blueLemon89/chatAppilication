package com.example.demo.repo;

import com.example.demo.entity.ChatroomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatroomRepo extends JpaRepository<ChatroomEntity, Long> {
}
