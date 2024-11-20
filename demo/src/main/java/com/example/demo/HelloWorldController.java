package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloWorldController {

    // Page d'accueil après connexion réussie
    @GetMapping("/home") 
    public String homePage(Model model) {
        model.addAttribute("message", "Welcome on What a Leak!");
        return "hello"; // Renvoie vers hello.html
    }
}
