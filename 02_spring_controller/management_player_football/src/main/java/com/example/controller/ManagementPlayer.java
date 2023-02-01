package com.example.controller;

import com.example.model.Player;
import com.example.service.IManagementPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ManagementPlayer {
    @Autowired
    private IManagementPlayerService iManagementPlayerService;

    @GetMapping("")
    public String showList(Model model) {
        model.addAttribute("playerList", iManagementPlayerService.findAll());
        return "list";
    }

    @GetMapping("/detail/{id}")
    public ModelAndView showDetail(@PathVariable int id) {
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
}
