package com.berkanaslan.springsecurityexample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SpringSecurityExampleController {
    @GetMapping("/")
    public String showHome() {

        return "home";
    }
}
