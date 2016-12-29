package com.example.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping(value = "/")
    @PreAuthorize("hasRole('ADMIN')")
    public String getHome() {
        return "index";
    }

    @RequestMapping(value = "/login")
    public String getLogin() {
        return "login";
    }

}
