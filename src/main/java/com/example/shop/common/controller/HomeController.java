package com.example.shop.common.controller;

import com.example.shop.common.annotation.Login;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @GetMapping("/main")
    public String home(@Login Long userId, HttpSession session, Model model) {
        return "common/index";
    }

}
