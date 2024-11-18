package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class DataController {

    @Autowired
    private DataService dataService;


    public DataController(DataService dataService) {
        this.dataService = dataService;
    }

    // Affiche la page index.html avec les données du fichier JSON
    @GetMapping("/data")
    public String showDataPage(Model model) throws IOException {
        // Charger les données depuis le fichier JSON
        var data = dataService.getDataFromJson("data.json");
        System.out.println("Données pour la vue : " + data);
        // Passer les données au modèle pour les rendre accessibles à Thymeleaf
        model.addAttribute("data", data);

        // Renvoie vers la vue index.html
        return "index";
    }
}
