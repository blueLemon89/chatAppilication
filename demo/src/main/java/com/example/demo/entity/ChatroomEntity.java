package com.example.demo.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class ChatroomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column
    private String description;

    @ManyToMany
    private Set<UserEntity> members = new HashSet<>();

    @Column
    private Timestamp createdAt;

    @Column
    private Timestamp updatedAt;

    @Column(nullable = false)
    private boolean deleteFlag;

}
