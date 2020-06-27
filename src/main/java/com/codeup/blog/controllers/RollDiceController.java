package com.codeup.blog.controllers;

import com.codeup.blog.models.Ad;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

@Controller
public class RollDiceController {

    @GetMapping("/roll-dice/{number}")
    public String rollDice(@PathVariable int guess, Model model) {
        int randomNumber = ThreadLocalRandom.current().nextInt(1, 6 + 1);
        model.addAttribute("isCorrectGuess", randomNumber == guess);
        model.addAttribute("myGuess", guess);
        model.addAttribute("randomNumber", randomNumber);

        return "roll-dice";
    }

    @GetMapping("/roll-dice")
    public String displayRollDice() {
        return "roll-dice";
    }

}
