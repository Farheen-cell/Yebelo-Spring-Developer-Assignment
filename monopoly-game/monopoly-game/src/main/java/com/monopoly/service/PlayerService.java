package com.monopoly.service;

import com.monopoly.paylode.PlayerDTO;

public interface PlayerService {

    Integer getPlayerBalance(Long playerId);

    String roleDice(Long playerId, Long gameId);

    PlayerDTO deletePlayer(Long playerId);

    public String CalculateWinner(Long gameId);
}
