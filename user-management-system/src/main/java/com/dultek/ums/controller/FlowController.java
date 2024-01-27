package com.dultek.ums.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FlowController {

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
}
