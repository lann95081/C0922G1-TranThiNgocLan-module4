package com.example.management_player_football.controller;

import com.example.management_player_football.dto.PlayerDto;
import com.example.management_player_football.model.Player;
import com.example.management_player_football.service.IPlayerService;
import com.example.management_player_football.service.ITeamService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PlayerController {
    @Autowired
    private IPlayerService iPlayerService;

    @Autowired
    private ITeamService iTeamService;

    @GetMapping("")
    public String showList(@PageableDefault(value = 2) Pageable pageable, @RequestParam(value = "search", defaultValue = "")
            String search, Model model) {
        model.addAttribute("playerList", iPlayerService.searchName(search, pageable));
        model.addAttribute("teamList", iTeamService.findAll());
        model.addAttribute("search", search);
        return "list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        List<String> positions = new ArrayList<>();
        positions.add("Trung vệ");
        positions.add("Hậu vệ");
        positions.add("Tiền vệ");
        positions.add("Tiền đạo");
        positions.add("Thủ môn");
        model.addAttribute("playerDto", new PlayerDto());
        model.addAttribute("teamList", iTeamService.findAll());
        model.addAttribute("positions", positions);
        return "create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute @Validated PlayerDto playerDto, BindingResult bindingResult,
                       RedirectAttributes redirectAttributes) {
        new PlayerDto().validate(playerDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "create";
        } else {
            Player player = new Player();
            BeanUtils.copyProperties(playerDto, player);
            iPlayerService.save(player);
            redirectAttributes.addFlashAttribute("mess", "Them moi thanh cong.");
        }
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        Player player = iPlayerService.findById(id);

        PlayerDto playerDto = new PlayerDto();
        BeanUtils.copyProperties(playerDto, player);

        model.addAttribute("playerDto", playerDto);
        model.addAttribute("teamList", iTeamService.findAll());
        return "edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute @Validated PlayerDto playerDto, BindingResult bindingResult,
                         RedirectAttributes redirectAttributes, Model model) {

        new PlayerDto().validate(playerDto, bindingResult);

        if (bindingResult.hasErrors()) {
            model.addAttribute("playerDto",playerDto);
            model.addAttribute("teamList", iTeamService.findAll());

            return "edit";
        }

        Player player = new Player();
        BeanUtils.copyProperties(playerDto, player);
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
