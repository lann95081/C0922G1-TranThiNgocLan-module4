package com.example.repository;

import com.example.model.Player;

import java.util.List;

public interface IManagementPlayerRepository {
    List<Player> findAll();

    void delete(int id);
//
    Player findById(int id);
//
    void save(Player player);
}
