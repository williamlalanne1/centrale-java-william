package org.centrale.api.service;
import java.util.*;

import org.centrale.api.entity.GameEntity;
import org.centrale.api.repository.GameRepository;
import org.centrale.api.entity.PlayerEntity;
import org.centrale.api.repository.PlayerRepository;
import org.centrale.domain.*;
import org.springframework.stereotype.Component;

@Component
public class GameService {

    final PlayerRepository playerRepository;
    final GameRepository gameRepository;
    public GameService(PlayerRepository playerRepository, GameRepository gameRepository) {
        this.playerRepository = playerRepository;
        this.gameRepository = gameRepository;
    }

    public List<String> historyOfWinner = new ArrayList<>();
    public List<String> historyOfLoser = new ArrayList<>();

    public Game game = new Game();

    public String playGame(Integer playerId1, Integer playerId2, String hand1, String hand2){
        GameEntity gameEntity = new GameEntity();
        Integer maxId = gameRepository.findMaxGameEntityId();

        gameEntity.setId(maxId + 1);

        Player player1 = new Player();
        player1.hand = hand1;
        player1.name = playerId1.toString();

        Player player2 = new Player();
        player2.hand = hand2;
        player2.name = playerId2.toString();

        String res = game.play(player1, player2);
        String ret = "";
        if(res.equals("Egalité")){
            if(res.equals("Gagné")){
                ret = "Player with playerId " + player1.name + " wins this one";
                historyOfWinner.add(playerId1.toString());
                historyOfLoser.add(playerId2.toString());
            } else if(res.equals("Perdu"))
            {
                ret = "Player with playerId " + player2.name + " wins this one";
                historyOfWinner.add(playerId2.toString());
                historyOfLoser.add(playerId1.toString());
            }
        } else {
            ret = "draw";
        }
        gameEntity.setDescription(ret);
        gameRepository.save(gameEntity);

        return ret;
    }

    public List<String> getHistoryOfWinner(){
        return historyOfWinner;
    }

    public String getStats(Integer id){

        Integer countWins = 0;
        Integer countLose = 0;
        List<Integer> losingOpponents = new ArrayList<>();

        for (int i = 0; i < historyOfWinner.size(); i++) {

            if(id.toString().equals(historyOfWinner.get(i))){
                countWins++;
                losingOpponents.add(Integer.parseInt(historyOfLoser.get(i)));
            }
            if(id.toString().equals(historyOfLoser.get(i))){
                countLose++;
            }

        }

        Integer worstOpponentId = Collections.max(losingOpponents, Comparator.comparingInt(o -> Collections.frequency(losingOpponents, o)));

        return("Le joueur " + id.toString() + " a gagné " + countWins.toString() + " fois et a perdu " + countLose.toString() +
                " fois. Le pire adversaire a été " + worstOpponentId );
    }

    public List<Player> getPlayerList(){
        return game.getList();
    }

    public PlayerEntity getPlayerInfo(Integer id){
        PlayerEntity playerEntity = playerRepository.findById(id)
                .orElseThrow(NoSuchElementException::new);
        return playerEntity;
    }

    public void setHand(Integer playerId, String hand){
        PlayerEntity playerEntity = playerRepository.findById(playerId)
            .orElseThrow(NoSuchElementException::new);
        playerEntity.setHand(hand);
        playerRepository.save(playerEntity);
    }

    public void addPlayer(String name){
        PlayerEntity playerEntity = new PlayerEntity();
        Player player = new Player();

        Integer maxId = playerRepository.findMaxPlayerEntityId();

        playerEntity.setId(maxId + 1);

        player.name = name;
        playerEntity.name = name;

        playerEntity.hand = "";

        game.addPlayer(player);
        playerRepository.save(playerEntity);
    }

    public void removePlayer(String playerName){
        for (int i = 0; i < game.playerList.size() ; i++) {
            if(playerName.equals(game.playerList.get(i).name)){
                game.removePlayer(game.playerList.get(i));
            }
        }
    }

}
