package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("user")
public class HelloWorldController {

    // Page d'accueil après connexion réussie
    @GetMapping("/home") 
    public String homePage(@ModelAttribute("user") User user, Model model) {
        if (user == null) {
            return "redirect:/logout";  // Si l'utilisateur n'est pas dans la session, redirige vers la page de connexion
        }
        if (CredentialService.isValidUser(user.getUsername(), user.getPassword())){
             // No need to revalidate credentials here; assume the user is logged in
            model.addAttribute("message", "Welcome " + user.getUsername() + " on What a Leak!");
            return "hello";
        }
        System.out.println("Nom d'utilisateur: " + user.getUsername());
        System.out.println("Nom d'utilisateur: " + user.getPassword());

        return "redirect:/logout";
    }
}
