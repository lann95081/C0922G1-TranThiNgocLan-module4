package com.example.controller;

import com.example.model.Player;
import com.example.service.IManagementPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
//@RequestMapping("/player")
public class ManagementPlayer {
    @Autowired
    private IManagementPlayerService iManagementPlayerService;

    @GetMapping("/")
    public String showList(Model model) {
        model.addAttribute("playerList", iManagementPlayerService.findAll());
        return "list";
    }

    @GetMapping("/detail")
    public ModelAndView showDetail(@RequestParam(value = "id",required = false,defaultValue = "0") int id) {
        ModelAndView modelAndView = new ModelAndView("detail");
        Player player = iManagementPlayerService.findById(id);
        modelAndView.addObject("player", player);
        return modelAndView;
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id, RedirectAttributes redirectAttributes) {
        iManagementPlayerService.delete(id);
        redirectAttributes.addFlashAttribute("mess", "Xoa thanh cong.");
        return "redirect:/";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("player", new Player());
        return "create";
    }
//
    @PostMapping("/create")
    public String save(@ModelAttribute Player player, Model model, RedirectAttributes redirectAttributes) {
        iManagementPlayerService.save(player);
        redirectAttributes.addFlashAttribute("mess", "Them moi thanh cong");
        return "redirect:/";
    }
}
