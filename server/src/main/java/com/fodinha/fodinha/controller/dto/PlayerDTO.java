package com.fodinha.fodinha.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlayerDTO {

    private Long id;
    private String name;

    public PlayerDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }


}
