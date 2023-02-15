package com.example.management_player_football.controller;

import com.example.management_player_football.model.Player;
import com.example.management_player_football.service.IPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class PlayerRestController {
    @Autowired
    private IPlayerService iPlayerService;

    @GetMapping("")
    public ResponseEntity<List<Player>> getAll() {
        List<Player> playerList = iPlayerService.findAll();
        if (playerList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Player> detail(@PathVariable int id) {
        Player player = iPlayerService.findById(id);

        if (player == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(player, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<List<Player>> add(@RequestBody Player player) {
        iPlayerService.save(player);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("")
    public ResponseEntity<List<Player>> edit(@RequestBody Player player) {
        iPlayerService.save(player);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
