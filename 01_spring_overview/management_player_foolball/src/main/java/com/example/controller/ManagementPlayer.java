package com.example.controller;

import com.example.model.Player;
import com.example.service.impl.ManagementPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ManagementPlayer {
    @Autowired
    private ManagementPlayerService managementPlayerService;

    @GetMapping("/list")
    public ModelAndView showList() {
        List<Player> playerList = managementPlayerService.findAll();
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("playerList", playerList);
        return modelAndView;
    }
}
