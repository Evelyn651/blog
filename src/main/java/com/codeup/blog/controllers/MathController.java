package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MathController {
    @GetMapping(path = "/add/{numberOne}/and/{numberTwo}")
    @ResponseBody
    public String add(@PathVariable double numberOne, @PathVariable double numberTwo) {
        return numberOne + " + " + numberTwo + " = " + (numberOne + numberTwo) ;
    }

    @GetMapping(path = "/subtract/{numberOne}/from/{numberTwo}")
    @ResponseBody
    public String subtract(@PathVariable double numberOne, @PathVariable double numberTwo){
        return numberOne + " - " + numberTwo + " = " + (numberTwo - numberOne);
    }

    @GetMapping(path = "/multiply/{numberOne}/and/{numberTwo}")
    @ResponseBody
    public String multiply(@PathVariable double numberOne, @PathVariable double numberTwo){
        return numberOne + " * " + numberTwo + " = " + (numberOne * numberTwo);
    }

    @GetMapping(path = "/divide/{numberOne}/and/{numberTwo}")
    @ResponseBody
    public String divide(@PathVariable double numberOne,  @PathVariable double numberTwo){
       return numberOne + " / " + numberTwo + " = " + (numberOne / numberTwo);
    }
}
