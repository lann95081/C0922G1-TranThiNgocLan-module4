package com.example.service.impl;

import com.example.model.Player;
import com.example.repository.IManagementPlayerRepository;
import com.example.service.IManagementPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagementPlayerService implements IManagementPlayerService {
    @Autowired
    private IManagementPlayerRepository iManagementPlayerRepository;

    @Override
    public List<Player> findAll() {
        return iManagementPlayerRepository.findAll();
    }

    @Override
    public void delete(int id) {
        iManagementPlayerRepository.delete(id);
    }

    @Override
    public Player findById(int id) {
        return iManagementPlayerRepository.findById(id);
    }

    @Override
    public void save(Player player) {
        for (Player players : iManagementPlayerRepository.findAll()) {
            if (players.getName().equals(player.getName())) {
                System.out.println("Player đã tồn tại");
            } else {
                iManagementPlayerRepository.save(player);
            }
        }
    }
}
