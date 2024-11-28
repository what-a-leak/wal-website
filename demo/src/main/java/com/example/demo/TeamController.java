package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("user")
public class TeamController {

@GetMapping("/team")  // When user tries to access /index.html
public String DataPage(@ModelAttribute("user") User user, Model model) {
        // Check if the user is in the session (i.e., logged in)
        if (user == null) {
            // If the session is complete, the user is logged out
            return "redirect:/logout";  // Redirect to login page or home page
        }
        if (CredentialService.isValidUser(user.getUsername(), user.getPassword())){
            // If user is logged in, proceed to show the page
            return "team.html";  // This should point to your index.html or a corresponding view
        }
        System.out.println("Nom d'utilisateur: " + user.getUsername());
        System.out.println("Nom d'utilisateur: " + user.getPassword());
        return "redirect:/logout";
       
        
    }
}
