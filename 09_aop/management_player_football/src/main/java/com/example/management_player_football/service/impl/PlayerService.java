package com.example.management_player_football.service.impl;

import com.example.management_player_football.model.Player;
import com.example.management_player_football.repository.IPlayerRepository;
import com.example.management_player_football.service.IPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService implements IPlayerService {
    @Autowired
    private IPlayerRepository iPlayerRepository;

    @Override
    public List<Player> findAll() {
        return iPlayerRepository.findAll();
    }

    @Override
    public void save(Player player) {
        iPlayerRepository.save(player);
    }

    @Override
    public Player findById(int id) {
        return iPlayerRepository.findById(id).get();
    }
}
