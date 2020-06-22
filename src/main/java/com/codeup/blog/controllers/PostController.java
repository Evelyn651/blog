package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
    @GetMapping(path = "/posts")
    @ResponseBody
    public String posts() {
        return "posts index page";
    }

    @GetMapping(path = "/posts/{post}")
    @ResponseBody
    public String posts(@PathVariable String post) {
        return "view an individual post";
    }

    @GetMapping(path = "/posts/create")
    @ResponseBody
    public String createPosts() {
        return "view the form for creating a post";
    }

    @RequestMapping(path = "/posts/create")
    @ResponseBody
    public String postPosts() {
        return "create a new post";
    }
}
