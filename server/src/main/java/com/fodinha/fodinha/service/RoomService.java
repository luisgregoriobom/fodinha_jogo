package com.fodinha.fodinha.service;

import com.fodinha.fodinha.controller.dto.RoomDTO;
import com.fodinha.fodinha.models.RoomModel;
import com.fodinha.fodinha.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomDTO getRoomByName(String name) {
        RoomDTO dto = new RoomDTO();
        RoomModel opt = roomRepository.findByRoomCode(name);

        if(opt == null){
            return null;
        }

        dto.setRoomCode(opt.getRoomCode());
        dto.setId(opt.getId());
        return dto;
    }

    public RoomDTO create(String name) {
        RoomModel model = new RoomModel();
        RoomDTO dto = new RoomDTO();

        model.setRoomCode(name);
        RoomModel result = roomRepository.save(model);

        dto.setRoomCode(result.getRoomCode());
        dto.setId(result.getId());

        return dto;
    }

    public List<RoomDTO> getAllRooms() {
        List<RoomModel> roomModel = roomRepository.findAll();
        List<RoomDTO> roomDto = new ArrayList<>();
        roomModel.forEach(room -> {
            RoomDTO dto = new RoomDTO();
            dto.setRoomCode(room.getRoomCode());
            dto.setId(room.getId());
            roomDto.add(dto);
        });
        return roomDto;
    }
}
