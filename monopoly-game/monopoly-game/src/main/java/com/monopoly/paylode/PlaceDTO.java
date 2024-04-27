package com.monopoly.paylode;

import com.monopoly.model.Game;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlaceDTO {
    private Long id;

    private String name;

    private int buyPrice;
    private int placeDiceValue;
    private Boolean placeSoledStatus;

    private int rent;

    private Game game;
}
