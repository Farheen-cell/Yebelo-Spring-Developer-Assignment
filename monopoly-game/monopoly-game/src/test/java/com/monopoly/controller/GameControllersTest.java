package com.monopoly.controller;
import com.monopoly.controllers.GameControllers;
import com.monopoly.paylode.GameDTO;
import com.monopoly.service.GameService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class GameControllersTest {

    @Mock
    private GameService gameService;

    @InjectMocks
    private GameControllers gameControllers;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void createNewGame_ValidGameDTO_ReturnsCreatedResponse() {
        // Arrange
        GameDTO gameDTO = new GameDTO();
        when(gameService.createGame(gameDTO)).thenReturn(gameDTO);

        // Act
        ResponseEntity<GameDTO> response = gameControllers.createNewGame(gameDTO);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(gameDTO, response.getBody());
    }

    // Add more test cases as needed
}

