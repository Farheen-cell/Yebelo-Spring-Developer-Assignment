package com.monopoly.service.impl;

import com.monopoly.config.AppConstants;
import com.monopoly.model.Game;
import com.monopoly.model.Place;
import com.monopoly.model.Player;
import com.monopoly.paylode.GameDTO;
import com.monopoly.paylode.PlayerDTO;
import com.monopoly.repository.GameRepo;
import com.monopoly.repository.PlaceRepo;
import com.monopoly.repository.PlayerRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class GameServiceImplTest {

    @Mock
    private GameRepo gameRepo;

    @Mock
    private PlaceRepo placeRepo;

    @Mock
    private PlayerRepo playerRepo;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private GameServiceImpl gameService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void createGameTest() {
        // Arrange
        GameDTO gameDTO = new GameDTO();
        PlayerDTO playerDTO1 = new PlayerDTO();
        playerDTO1.setName("Player 1");
        PlayerDTO playerDTO2 = new PlayerDTO();
        playerDTO2.setName("Player 2");
        List<PlayerDTO> playerDTOList = new ArrayList<>();
        playerDTOList.add(playerDTO1);
        playerDTOList.add(playerDTO2);
        gameDTO.setPlayers(playerDTOList);

        Place place1 = new Place();
        place1.setName("Place 1");
        Place place2 = new Place();
        place2.setName("Place 2");
        List<Place> placeList = new ArrayList<>();
        placeList.add(place1);
        placeList.add(place2);

        Game game = new Game();

        when(modelMapper.map(any(PlayerDTO.class), eq(Player.class)))
                .thenReturn(new Player())
                .thenReturn(new Player());

        when(placeRepo.findAll()).thenReturn(placeList);
        when(modelMapper.map(gameDTO, Game.class)).thenReturn(game);

        // Act
        GameDTO createdGameDTO = gameService.createGame(gameDTO);

        // Assert
        verify(playerRepo, times(2)).save(any(Player.class));
        verify(gameRepo).save(any(Game.class));
        // Add more assertions based on your requirements
    }

    // Add more test cases as needed
}

