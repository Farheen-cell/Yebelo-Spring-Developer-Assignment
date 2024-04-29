package com.monopoly.controller;
import com.monopoly.controllers.PlayerController;
import com.monopoly.service.PlayerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class PlayerControllerTest {

    @Mock
    private PlayerService playerService;

    @InjectMocks
    private PlayerController playerController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void roleDice_ValidPlayerIdAndGameId_ReturnsOkResponse() {
        // Arrange
        long playerId = 1L;
        long gameId = 1L;
        String gameStatus = "continue game";
        when(playerService.roleDice(playerId, gameId)).thenReturn(gameStatus);

        // Act
        ResponseEntity<String> response = playerController.roleDice(playerId, gameId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(gameStatus, response.getBody());
    }

    @Test
    void calculateWinner_ValidGameId_ReturnsOkResponse() {
        // Arrange
        long gameId = 1L;
        String message = "Player 1 is Winner";
        when(playerService.CalculateWinner(gameId)).thenReturn(message);

        // Act
        ResponseEntity<String> response = playerController.calculateWinner(gameId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(message, response.getBody());
    }

    // Add more test cases as needed
}

