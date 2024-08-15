package com.TrucksAuctions.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AppController {

    @GetMapping("/")
    public String startPage() {
        return "landing-page";
    }

    @GetMapping("/trucks")
    public String auctionsPage() {
        return "trucks";
    }
}
