package com.example.management_player_football.service;

import com.example.management_player_football.model.Player;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPlayerService {
    List<Player> findAll();

    void save(Player player);

    Player findById(int id);

    void delete(int id);

    Page<Player> searchName(String name, Pageable pageable);
}
