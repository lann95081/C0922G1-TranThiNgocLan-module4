package com.example.management_player_football.controller;

import com.example.management_player_football.dto.FavoriteDto;
import com.example.management_player_football.dto.PlayerDto;
import com.example.management_player_football.model.Player;
import com.example.management_player_football.service.IPlayerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("favorite")
public class PlayerController {
    @Autowired
    private IPlayerService iPlayerService;

    @ModelAttribute("favorite")
    public FavoriteDto initFavorite() {
        return new FavoriteDto();
    }

    @GetMapping("")
    public String showList(Model model) {
        model.addAttribute("playerList", iPlayerService.findAll());
        return "player/list";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable int id, Model model) {
        model.addAttribute("player", iPlayerService.findById(id));
        return "player/detail";
    }

    @GetMapping("add/{id}")
    public String addFavorite(@PathVariable int id, @SessionAttribute("favorite") FavoriteDto favorite){
        Player player=iPlayerService.findById(id);
        if (player!=null){
            PlayerDto playerDto =new PlayerDto();
            BeanUtils.copyProperties(player,playerDto);
            favorite.addFavoritePlayer(playerDto);
        }
        return "redirect:/favorite";
    }
}
