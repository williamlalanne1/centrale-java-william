package org.centrale.api.controller;

import org.centrale.api.repository.GameRepository;
import org.centrale.api.entity.PlayerEntity;
import org.centrale.api.service.GameService;
import org.centrale.domain.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExampleController {
    final GameService gameService;
    final GameRepository gameRepository;

    public ExampleController(GameService gameService, GameRepository gameRepository) {
        this.gameService = gameService;
        this.gameRepository = gameRepository;;
    }

    @GetMapping("/")
    public String hello() {return("Bienvenue pour jouer à Pierre Feuille Ciseaux");}

    @GetMapping("/play")
    public String play(@RequestParam Integer player1Id, @RequestParam Integer player2Id, @RequestParam String handPlayer1, @RequestParam String handPlayer2){
        gameService.setHand(player1Id, handPlayer1);
        gameService.setHand(player2Id, handPlayer2);
        return gameService.playGame(player1Id, player2Id, handPlayer1, handPlayer2);
    }

    @PostMapping("/player")
    public void addString(@RequestParam String name){
        gameService.addPlayer(name);
    }

    @GetMapping("/player/{id}")
    public PlayerEntity getPlayer(@PathVariable("id")Integer id){
        return gameService.getPlayerInfo(id);
    }

    @PostMapping("/remove")
    public void removeString(@RequestParam String name){
        gameService.removePlayer(name);
    }

}
