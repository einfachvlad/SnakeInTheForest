package com.project5.snakeintheforest.Models;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Players {
    private LinkedList<Player> players = new LinkedList<>();

    public LinkedList<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player player) {
        if (players.isEmpty()) {
            initialize();
            return;
        }

        for (int index = 0; index < players.size(); index++) {
            if (players.get(index).getScore().equals("-") || Integer.valueOf(player.getScore()) > Integer.valueOf(players.get(index).getScore())) {
                List<Player> subList = new ArrayList<>(players.subList(index, players.size() - 1));

                for (Player subListItem : subList)
                    players.removeLast();
                players.removeLast();
                players.add(player);

                for (Player subListItem : subList)
                    players.add(subListItem);
                break;
            }
        }
    }
    void initialize(){
        for (int item = 0; item < 10; item++)
            players.add(new Player("Player", "-"));
    }
}
