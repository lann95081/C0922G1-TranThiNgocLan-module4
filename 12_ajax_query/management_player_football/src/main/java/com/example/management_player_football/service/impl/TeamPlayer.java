package com.example.management_player_football.service.impl;

import com.example.management_player_football.model.Team;
import com.example.management_player_football.repository.ITeamRepository;
import com.example.management_player_football.service.ITeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamPlayer implements ITeamService {
    @Autowired
    private ITeamRepository iTeamRepository;

    @Override
    public List<Team> findAll() {
        return iTeamRepository.findAll();
    }
}
