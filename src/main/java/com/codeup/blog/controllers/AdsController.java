package com.codeup.blog.controllers;

import com.codeup.blog.models.Ads;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class AdsController {

    @GetMapping("/ads")
    public String index(Model model){
        ArrayList<Ad> adsList = new ArrayList<>();
        adsList.add(new Ad(""));
        model.addAttribute("noAdsFound", adsList.size() == 0);
        model.addAttribute("ads", adsList);
        return "ads/index";
    }

}
