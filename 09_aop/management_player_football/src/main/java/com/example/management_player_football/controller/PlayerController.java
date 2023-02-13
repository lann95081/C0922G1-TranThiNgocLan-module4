package com.example.management_player_football.controller;

import com.example.management_player_football.exception.ExceptionHandle;
import com.example.management_player_football.model.Player;
import com.example.management_player_football.service.IPlayerService;
import com.example.management_player_football.service.ITeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class PlayerController {
    @Autowired
    private IPlayerService iPlayerService;

    @Autowired
    private ITeamService iTeamService;

    @GetMapping("")
    public String showList(Model model) {
        List<Player> playerList = iPlayerService.findAll();
        if (playerList.size() > 11) {
            return "errorPage";
        }
        model.addAttribute("playerList", playerList);
        model.addAttribute("teamList", iTeamService.findAll());
        return "list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("player", iPlayerService.findById(id));
        model.addAttribute("teamList", iTeamService.findAll());
        return "edit";
    }

    @PostMapping("/update")
    public String update(Player player, RedirectAttributes redirectAttributes) {
        iPlayerService.save(player);
        redirectAttributes.addFlashAttribute("mess", "Chinh sua thanh cong.");
        return "redirect:/";
    }

    @ExceptionHandler(ExceptionHandle.class)
    public String showException() {
        return "errorPage";
    }
}
