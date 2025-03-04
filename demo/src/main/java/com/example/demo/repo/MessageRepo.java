package com.example.demo.repo;

import com.example.demo.entity.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepo extends JpaRepository<MessageEntity, Long> {
}
