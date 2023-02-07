package com.example.management_player_football.service.impl;

import com.example.management_player_football.model.Player;
import com.example.management_player_football.repository.IManagementPlayerRepository;
import com.example.management_player_football.service.IManagementPlayerService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
    public void save(Player player) {
        iManagementPlayerRepository.save(player);
    }

    @Override
    public Player findById(int id) {
        return iManagementPlayerRepository.findById(id).get();
    }

    @Override
    public void remove(Player player) {
        iManagementPlayerRepository.delete(player);
    }

    @Override
    public Page<Player> searchByName(String name, String fromDate, String toDate, Pageable pageable) {
        if (Strings.isBlank(fromDate) && Strings.isBlank(toDate)) {
            return iManagementPlayerRepository.searchByNameContaining("%" + name + "%", pageable);
        }
        return iManagementPlayerRepository.searchByNameContainingAndDayOfBirthBetween("%" + name + "%", LocalDate.parse(fromDate), LocalDate.parse(toDate), pageable);
    }


}
