package org.centrale.domain;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public List<Player> playerList = new ArrayList<>();

    public void addPlayer(Player player){
        playerList.add(player);
    }

    public void removePlayer(Player player){
        var index = playerList.indexOf(player);
        if (index != -1) {
            playerList.remove(index);
        }
    }

    public List<Player> getList(){
        return playerList;
    }

    public String play(Player player1, Player player2){
        Hand hand1;
        Hand hand2;

        if (player1.hand.equals("Pierre")){
            hand1 = new Pierre();
        } else if (player1.hand.equals("Feuille")){
            hand1 = new Feuille();
        } else {
            hand1 = new Ciseaux();
        }
        if (player2.hand.equals("Pierre")){
            hand2 = new Pierre();
        } else if (player2.hand.equals("Feuille")){
            hand2 = new Feuille();
        } else {
            hand2 = new Ciseaux();
        }

        String result = hand1.playWith(hand2);

        return result;
    }
}
