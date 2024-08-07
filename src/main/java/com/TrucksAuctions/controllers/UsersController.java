package com.TrucksAuctions.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.TrucksAuctions.models.UserEntity;
import com.TrucksAuctions.services.UsersService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class UsersController {

    @Autowired
    UsersService usersService;

    @GetMapping("/register")
    public String registerForm(Model model) {
        UserEntity user = new UserEntity();
        model.addAttribute("user", user);
        return "register";
    }

    @GetMapping("/login-page")
    public String loginPage() {
        return "login-page";
    }
    

    @PostMapping("/user/register")
    public String registerUser(@ModelAttribute UserEntity user, 
                               BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("user", user);
            return "register";
        }
        try {
            usersService.saveUser(user);
        } catch (IllegalArgumentException e) {
            model.addAttribute("errorMessage", e.getMessage());
            model.addAttribute("user", user);
            return "register";
        }
        return "redirect:/login-page";
    }
}
