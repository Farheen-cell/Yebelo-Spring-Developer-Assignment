package com.monopoly.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "places")
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotNull
    @Min(value = 0)
    private int buyPrice;

    @NotNull
    @Min(value = 0)
    private int rent;

    @NotNull
    private int placeDiceValue;


    private Boolean placeSoledStatus;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    // Constructors, getters, setters
}
