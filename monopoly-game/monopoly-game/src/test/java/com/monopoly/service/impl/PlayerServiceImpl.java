package com.monopoly.service.impl;

import com.monopoly.config.AppConstants;
import com.monopoly.exceptions.ResourceNotFoundException;
import com.monopoly.model.Player;
import com.monopoly.repository.GameRepo;
import com.monopoly.repository.PlaceRepo;
import com.monopoly.repository.PlayerRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class PlayerServiceImplTest {

    @Mock
    private PlayerRepo playerRepo;

    @Mock
    private PlaceRepo placeRepo;

    @Mock
    private GameRepo gameRepo;

    @Mock
    private Random random;

    @InjectMocks
    private PlayerServiceImpl playerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getPlayerBalance_WhenPlayerExists_ReturnsPlayerBalance() {
        // Arrange
        long playerId = 1L;
        int expectedBalance = 1000;
        Player player = new Player();
        player.setCash(expectedBalance);
        when(playerRepo.findById(playerId)).thenReturn(Optional.of(player));

        // Act
        Integer actualBalance = playerService.getPlayerBalance(playerId);

        // Assert
        assertEquals(expectedBalance, actualBalance);
    }

    @Test
    void roleDice_WhenPlayerExistsAndHasRemainingRolls_ReturnsUpdatePlayerResult() {
        // Arrange
        long playerId = 1L;
        long gameId = 1L;
        int diceValue1 = 3;
        int diceValue2 = 4;
        int playerPositionToBeChange = diceValue1 + diceValue2;
        String expectedUpdateResult = "continue game";
        Player player = new Player();
        player.setDiceRollingCount(AppConstants.DICE_MAX_COUNT - 1);
        player.setPositionValue(0);
        when(playerRepo.findById(playerId)).thenReturn(Optional.of(player));
        when(random.nextInt(6)).thenReturn(diceValue1 - 1, diceValue2 - 1);

        // Act
        String actualUpdateResult = playerService.roleDice(playerId, gameId);

        // Assert
        assertEquals(expectedUpdateResult, actualUpdateResult);
        assertEquals(playerPositionToBeChange, player.getPositionValue());
    }

    @Test
    void roleDice_WhenPlayerExistsAndHasNoRemainingRolls_ReturnsCalculateWinnerResult() {
        // Arrange
        long playerId = 1L;
        long gameId = 1L;
        Player player = new Player();
        player.setDiceRollingCount(AppConstants.DICE_MAX_COUNT + 1);
        when(playerRepo.findById(playerId)).thenReturn(Optional.of(player));

        // Act & Assert
        assertThrows(ResourceNotFoundException.class, () -> playerService.roleDice(playerId, gameId));
    }

    // Add more test cases as needed
}

