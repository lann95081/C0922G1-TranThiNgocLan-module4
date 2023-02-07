package com.example.management_player_football.repository;

import com.example.management_player_football.model.Player;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface IManagementPlayerRepository extends JpaRepository<Player, Integer> {
    //    @Query(value = "select * from Player where name like %:name%", nativeQuery = true)
    Page<Player> searchByNameLike(String name, Pageable pageable);

    Page<Player> searchByNameContainingAndDayOfBirthBetween(String name, @Param("startDate") LocalDate startDate,
                                                            @Param("endDate") LocalDate endDate, Pageable pageable);
}
