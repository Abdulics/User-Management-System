package com.dultek.ums.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FlowController {

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/index.html")
    public String index() {
        return "index";
    }

    @GetMapping("/forGotPassword")
    public String forGotPass() {
        return "forGotPassword";
    }

    @PostMapping("/login")
    public String loginPageInitial() {
        return "welcomeBar";
    }

    @GetMapping("/profile")
    public String profile() {
        return "profile";
    }

    @GetMapping("/schedule")
    public String schedule() {
        return "schedule";
    }

    @GetMapping("/resetPassword")
    public String resetPassword() {
        return "resetPassword";
    }

}
