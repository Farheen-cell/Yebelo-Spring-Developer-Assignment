package com.monopoly.service;

import com.monopoly.paylode.GameDTO;
import com.monopoly.paylode.PlayerDTO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service

public interface GameService {

    GameDTO createGame(GameDTO gameDTO);

    GameDTO deleteGame(Long gameID);




}
