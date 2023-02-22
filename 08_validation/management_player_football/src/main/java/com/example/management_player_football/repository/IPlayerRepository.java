package com.example.management_player_football.repository;

import com.example.management_player_football.model.Player;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IPlayerRepository extends JpaRepository<Player, Integer> {
    Page<Player> findByNameContaining(String name, Pageable pageable);
}
