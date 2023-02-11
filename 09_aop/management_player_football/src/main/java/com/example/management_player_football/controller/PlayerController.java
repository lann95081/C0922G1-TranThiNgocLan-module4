package com.example.management_player_football.controller;

import com.example.management_player_football.service.IPlayerService;
import com.example.management_player_football.service.ITeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PlayerController {
    @Autowired
    private IPlayerService iPlayerService;

    @Autowired
    private ITeamService iTeamService;

    @GetMapping("")
    public String showList(Model model){
        model.addAttribute("playerList",iPlayerService.findAll());
        model.addAttribute("teamList",iTeamService.findAll());
        return "list";
    }
}
