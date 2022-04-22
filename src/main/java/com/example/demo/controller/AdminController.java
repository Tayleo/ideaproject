package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class AdminController {

    /**
     * 跳转到登录页面
     */
    @GetMapping("/login")
    public String toLogin() {
        return "/login";
    }

    /**
     * 跳转到主要页面
     */
    @GetMapping("/index")
    public String to() {
        return "/index";
    }
}
