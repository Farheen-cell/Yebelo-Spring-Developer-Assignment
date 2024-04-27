package com.monopoly.service.impl;

import com.monopoly.config.AppConstants;
import com.monopoly.exceptions.ResourceNotFoundException;
import com.monopoly.model.Game;
import com.monopoly.model.Place;
import com.monopoly.model.Player;
import com.monopoly.paylode.PlayerDTO;
import com.monopoly.repository.GameRepo;
import com.monopoly.repository.PlaceRepo;
import com.monopoly.repository.PlayerRepo;
import com.monopoly.service.PlayerService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private Random random;

    @Autowired
    PlayerRepo playerRepo;

    @Autowired
    PlaceRepo placeRepo;

    @Autowired
    GameRepo gameRepo;

    @Override
    public Integer getPlayerBalance(Long playerId) {
        return null;
    }

    @Override
    public String roleDice(Long playerId, Long gameId) {

        Player player = playerRepo.findById(playerId)
                .orElseThrow(() -> new ResourceNotFoundException("Player", "playerId", playerId));
        if (player.getDiceRollingCount() > AppConstants.DICE_MAX_COUNT) {
            return CalculateWinner(gameId);
        } else {
            int diceValue1 = random.nextInt(6) + 1;
            int diceValue2 = random.nextInt(6) + 1;
            int playerPositionToBeChange = diceValue1 + diceValue2;
            return UpdatePlayer(playerPositionToBeChange, playerId, gameId);
        }
    }

public String UpdatePlayer(int playerPositionToBeChange,long playerId, long gameId){



    Player player = playerRepo.findById(playerId)
            .orElseThrow(() -> new ResourceNotFoundException("Player", "playerId", playerId));

    player.setPositionValue(player.getPositionValue()+playerPositionToBeChange);

    int playerCurrentPosition = player.getPositionValue();
    if(playerCurrentPosition >= AppConstants.MAX_POSITION_ON_BORD){
        player.setCash(player.getCash() + AppConstants.CROSSING_START);
    }

    Place placeOnPlayerCurrentPosition = placeRepo.findByPlaceDiceValue(playerCurrentPosition);

    if(placeOnPlayerCurrentPosition.getPlaceSoledStatus()){
        int rent =placeOnPlayerCurrentPosition.getRent();
        if(rent > player.getCash()){
            gameRepo.deleteById(gameId);
            return player.getName() +" loos the game";
        }else{
        player.setCash(player.getCash()-rent);

        }
    }else{
        int buyPrice = placeOnPlayerCurrentPosition.getBuyPrice();
        if(buyPrice> player.getCash()){
            gameRepo.deleteById(gameId);
            return player.getName() +" loos the game";
        }else{
            player.setCash(player.getCash() - buyPrice);

        }

    }

    return "continue game";
        }






    public String CalculateWinner(Long gameId){
        Game game = gameRepo.findById(gameId)
                .orElseThrow(() -> new ResourceNotFoundException("Game", "gameId", gameId));

        List<Player> playerList = game.getPlayers();
        Player player1 = playerList.get(0);
        Player player2 = playerList.get(1);
        if(player1.getCash() > player2.getCash()){
           gameRepo.delete(game);
            return player1.getName()+ " is Winner";
        }else{
            gameRepo.delete(game);
            return player2.getName()+ "is Winner";
        }

    }

    @Override
    public PlayerDTO deletePlayer(Long playerId) {
        return null;
    }
}
