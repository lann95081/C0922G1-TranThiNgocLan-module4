package com.example.management_player_football.service;

import com.example.management_player_football.model.Player;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IManagementPlayerService {
    List<Player> findAll();

    void save(Player player);

    Player findById(int id);

    void remove(Player player);

    Page<Player> searchByName(String name, String fromDate, String toDate, Pageable pageable);
}
