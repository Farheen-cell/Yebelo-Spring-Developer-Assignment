package com.monopoly.controllers;

import com.monopoly.service.PlayerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @GetMapping("/roll-die/{playerId}/{gameId}")
    public ResponseEntity<String> roleDice(@Valid @PathVariable Long playerId, @PathVariable Long gameId){
        String gameStatus = playerService.roleDice(playerId,gameId);

        return new ResponseEntity<String>(gameStatus,HttpStatus.OK);
    }

    @GetMapping("/calculate-winner/{gameId}")
    public ResponseEntity<String> calculateWinner(@Valid @PathVariable Long gameId){
        String message = playerService.CalculateWinner(gameId);

        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
