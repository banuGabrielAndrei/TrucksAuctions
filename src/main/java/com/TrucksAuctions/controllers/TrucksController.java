package com.TrucksAuctions.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.TrucksAuctions.models.Truck;
import com.TrucksAuctions.services.TrucksService;

@Controller
public class TrucksController {

    @Autowired
    TrucksService trucksService;

    @GetMapping("/trucks")
    public String allTrucks() {
        return "trucks";
    }

    @GetMapping("/add-trucks")
    public String addTruckForm(Model model) {
        model.addAttribute("truck", new Truck());
        return "add-trucks";
    }

    @PostMapping("/trucks/save")
    public String saveTrucks(@ModelAttribute Truck truck, Model model,
        BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/add-trucks";
        }
        trucksService.saveTruck(truck);
        return "redirect:/trucks";    
    }
}
