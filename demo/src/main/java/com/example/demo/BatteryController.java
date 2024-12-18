package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("user")
public class BatteryController {

    @GetMapping("/battery")  // When user accesses /battery
    public String batteryPage(@ModelAttribute("user") User user, Model model) {
        // Check if the user is in the session (i.e., logged in)
        if (user == null) {
            // If the session is complete, redirect to logout or login page
            return "redirect:/logout";
        }

        // Validate the user's credentials
        if (CredentialService.isValidUser(user.getUsername(), user.getPassword())) {
            // Add attributes or data to the model if necessary
            model.addAttribute("username", user.getUsername());
            return "battery.html";  // Render the battery.html page
        }

        // If the user is invalid, redirect to logout or an error page
        return "redirect:/logout";
    }
}
