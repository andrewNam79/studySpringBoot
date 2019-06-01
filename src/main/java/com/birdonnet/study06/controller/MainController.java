package com.birdonnet.study06.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String ctrIndex(){
        return "index";
    }

    @GetMapping("joinPage")
    public String ctrJoin(){
        return "joinPage";
    }

    @GetMapping("login")
    public String ctrLogin(){
        return "login";
    }
}
