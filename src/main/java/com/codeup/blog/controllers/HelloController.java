package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

    @GetMapping("/hello")
    @ResponseBody
    public String hello(){return "Hello from spring";}

    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable String name, Model model){
        model.addAttribute("sayHelloName", name);
        return "hello";
    }

    @GetMapping("/hello-list")
    public String helloList(Model model){
        List<String> names = new ArrayList<>();
        names.add("Douglas");
        names.add("Fernando");
        model.addAttribute("names", names);
        return "hello-list";
    }

    @GetMapping("/join")
    public String showJoinForm(){
        return "join";
    }

    @PostMapping("/join")
    public String joinCohort(@RequestParam String cohort, Model model){
        model.addAttribute("cohort", cohort);
        return "join";
    }
}
