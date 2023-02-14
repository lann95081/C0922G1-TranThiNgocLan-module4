package com.example.management_player_football.controller;

import com.example.management_player_football.dto.FavoriteDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FavoriteController {

    @GetMapping("/favorite")
    public ModelAndView showFavorite(@SessionAttribute(value = "favorite",required = false) FavoriteDto favorite){
        return new ModelAndView("favorite/list", String.valueOf(favorite),favorite);
    }
}
