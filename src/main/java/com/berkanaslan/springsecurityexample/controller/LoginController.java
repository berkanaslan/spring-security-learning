package com.berkanaslan.springsecurityexample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Berkan Aslan
 * 23.03.2021
 */

@Controller
public class LoginController {

    @GetMapping("showLoginPage")
    public String showLoginPage() {
        return "login";
    }

}
