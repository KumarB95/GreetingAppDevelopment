package com.bridgelabz.greetingappdevelopment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AlienController {

    @RequestMapping("/data")
    public String home(){
        return "home.html";
    }
}
