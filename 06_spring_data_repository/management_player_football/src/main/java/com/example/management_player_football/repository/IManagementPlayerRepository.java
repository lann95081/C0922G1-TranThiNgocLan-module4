package com.example.management_player_football.repository;

import com.example.management_player_football.model.Player;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IManagementPlayerRepository extends JpaRepository<Player, Integer> {
    @Query(value = "select * from Player where name like %:name%", nativeQuery = true)
    Page<Player> searchByName(@Param("name") String name, Pageable pageable);
}
