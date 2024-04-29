package com.monopoly.paylode;

import com.monopoly.model.Place;
import com.monopoly.model.Player;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameDTO {
    private Long id;

    private List<PlayerDTO> players;

    private List<PlaceDTO> places;
}
