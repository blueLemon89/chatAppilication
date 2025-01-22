package com.example.demo.repo;

import com.example.demo.DTO.ChatRoomDTO;
import com.example.demo.entity.ChatroomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatroomRepo extends JpaRepository<ChatroomEntity, Long> {

    @Query(value = "select ce.id, ce.name from chatroom_entity ce join chatroom_entity_members cem on ce.id = cem.chatroom_entity_id \n" +
            "where cem.members_id = :id", nativeQuery = true)
    List<ChatRoomDTO> findByLoggedUserId(@Param("id") Long id);

}
