package com.fodinha.fodinha.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoomDTO {

    private Long id;
    private String roomCode;
}
