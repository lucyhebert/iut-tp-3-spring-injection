package edu.lyon1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Autowired
    private Utilisateur utilisateur;

    @RequestMapping("/")
    public Boolean utilisateur(
            @RequestParam(value = "prenom", defaultValue = "") String prenom,
            @RequestParam(value = "nom", defaultValue = "") String nom) {
        return utilisateur.getPrenom().equals(prenom) && utilisateur.getNom().equals(nom);
    }
}
