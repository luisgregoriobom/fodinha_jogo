package com.fodinha.fodinha.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "player_model")
public class PlayerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public PlayerModel(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}

