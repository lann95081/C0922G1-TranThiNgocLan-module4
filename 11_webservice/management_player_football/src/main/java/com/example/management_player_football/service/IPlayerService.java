package com.example.management_player_football.service;

import com.example.management_player_football.model.Player;

import java.util.List;

public interface IPlayerService {
    List<Player> findAll();

    void save(Player player);

    Player findById(int id);
}
