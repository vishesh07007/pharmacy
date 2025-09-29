package com.sunrise.pharmacy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("title","Sunrise Pharmacy");
        model.addAttribute("welcomeMessage", "Welcome to Sunrise Pharmacy Management System");
        return "home";
    }

    @GetMapping("/about")
    public String about(Model model){
        model.addAttribute("title","About Us - Sunrise Pharmacy");
        return "about";
    }

    @GetMapping("/contact")
    public String contact(Model model) {
        model.addAttribute("title", "Contact Us - Sunrise Pharmacy");
        return "contact";
    }


}
