package com.fodinha.fodinha.repository;

import com.fodinha.fodinha.controller.dto.RoomDTO;
import com.fodinha.fodinha.models.RoomModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<RoomModel, Long> {
    RoomModel findByRoomCode(String name);
}
