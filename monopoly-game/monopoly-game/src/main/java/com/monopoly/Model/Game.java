package com.monopoly.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "games")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Add more fields as needed

    @OneToMany(mappedBy = "game")
    private List<Player> players;

    @OneToMany(mappedBy = "game")
    private List<Place> places;

}
