package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("user")
public class LoginController {

    // Page de connexion
    @GetMapping("/")  // Ou vous pouvez aussi mettre /login pour la page de connexion
    public String showLoginPage() {
        return "login";  // Affiche la page de connexion (login.html)
    }

    // Traitement du formulaire de connexion
    @PostMapping("/login")  // Changer la route POST pour correspondre au formulaire
    public String handleLogin(@RequestParam("username") String username, 
                              @RequestParam("password") String password, Model model) {
        // Vérification des informations de connexion à partir du fichier credentials.json
        User user = new User();
        user.setUsername("pasbon");
        user.setPassword("pasbon");
        if (CredentialService.isValidUser(username, password)) {
            user.setUsername(username);
            user.setPassword(password);
            model.addAttribute("user", user);  // Ajouter un attribut de session, si nécessaire
            return "redirect:/home";  // Redirige vers la page d'accueil après une connexion réussie
        } else {
            model.addAttribute("error", "Nom d'utilisateur ou mot de passe incorrect");
            return "login";  // Retourne à la page de connexion en cas d'erreur
        }
    }
}
