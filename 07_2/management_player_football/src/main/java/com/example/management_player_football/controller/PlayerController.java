package com.example.management_player_football.controller;

import com.example.management_player_football.model.Player;
import com.example.management_player_football.service.IPlayerService;
import com.example.management_player_football.service.ITeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PlayerController {
    @Autowired
    private IPlayerService iPlayerService;

    @Autowired
    private ITeamService iTeamService;

    @GetMapping("")
    public String showList(@PageableDefault(value = 2) Pageable pageable, @RequestParam(value = "search", defaultValue = "")
            String search, Model model) {
        model.addAttribute("playerList", iPlayerService.searchName(search,pageable));
        model.addAttribute("teamList", iTeamService.findAll());
        model.addAttribute("search", search);
        return "list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("player", new Player());
        model.addAttribute("teamList", iTeamService.findAll());
        return "create";
    }

    @PostMapping("/save")
    public String save(Player player, RedirectAttributes redirectAttributes) {
        iPlayerService.save(player);
        redirectAttributes.addFlashAttribute("mess", "Them moi thanh cong.");
        return "redirect:/";
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

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, RedirectAttributes redirectAttributes) {
        iPlayerService.delete(id);
        redirectAttributes.addFlashAttribute("mess", "Xoa thanh cong.");
        return "redirect:/";
    }

}
