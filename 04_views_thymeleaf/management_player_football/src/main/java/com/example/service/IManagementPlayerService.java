package com.example.service;

import com.example.model.Player;

import java.util.List;
import java.util.Optional;

public interface IManagementPlayerService {
    List<Player> findAll();

    void save(Player player);

    Player findById(int id);

    void remove(int id);
}
