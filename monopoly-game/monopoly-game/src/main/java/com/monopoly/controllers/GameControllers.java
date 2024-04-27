package com.monopoly.controllers;

import com.monopoly.paylode.GameDTO;
import com.monopoly.paylode.PlayerDTO;
import com.monopoly.service.GameService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class GameControllers {

 @Autowired
    GameService gameService;

    @PostMapping("/create-game")
    public ResponseEntity<GameDTO> createNewGame(@Valid @RequestBody GameDTO gameDTO) {

        GameDTO savedGame = gameService.createGame(gameDTO);

        return new ResponseEntity<GameDTO>(savedGame, HttpStatus.CREATED);
    }

}
