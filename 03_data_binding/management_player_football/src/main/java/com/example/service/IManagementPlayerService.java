package com.example.service;

import com.example.model.Player;

import java.util.List;

public interface IManagementPlayerService {
    List<Player> findAll();

    void delete(int id);

    Player findById(int id);

    void save(Player player);
}
