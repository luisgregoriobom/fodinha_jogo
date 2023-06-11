package com.fodinha.fodinha.controller;

import com.fodinha.fodinha.controller.dto.RoomDTO;
import com.fodinha.fodinha.controller.dto.RoomNameDTO;
import com.fodinha.fodinha.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
@RequestMapping("/rooms")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RoomController {

    private final RoomService roomService;


    @GetMapping
    public ResponseEntity<List<RoomDTO>> getAllRooms(){

        List<RoomDTO> roomsList = roomService.getAllRooms();

        return ResponseEntity.ok(roomsList);
    }

    @PostMapping
    public ResponseEntity<RoomDTO> createRoom(@RequestBody RoomNameDTO request) {
        RoomDTO queryByName = roomService.getRoomByName(request.getName());
        if (queryByName != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Room already exists");
        }
        RoomDTO teste = roomService.create(request.getName());

        return ResponseEntity.ok(teste);
    }
}
