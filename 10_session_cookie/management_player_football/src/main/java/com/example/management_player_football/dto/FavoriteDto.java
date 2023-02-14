package com.example.management_player_football.dto;

import java.util.HashMap;
import java.util.Map;

public class FavoriteDto {
    private Map<PlayerDto, String> playerMap = new HashMap<>();

    public FavoriteDto() {
    }

    public Map<PlayerDto, String> getPlayerMap() {
        return playerMap;
    }

    public void setPlayerMap(Map<PlayerDto, String> playerMap) {
        this.playerMap = playerMap;
    }

    public void addFavoritePlayer(PlayerDto playerDto) {
        if (playerMap.containsKey(playerDto)) {
            String status = playerMap.get(playerDto);
            playerMap.replace(playerDto, status);
        } else {
            playerMap.put(playerDto, "");
        }
    }
}
