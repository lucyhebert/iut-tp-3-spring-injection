package edu.lyon1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

/**
 * Created by p1614402 on 04/05/2017.
 */

public class Utilisateur {

    @Value("${nom}")
    String nom;

    @Value("${prenom}")
    String prenom;

    public Utilisateur() {
        this.nom = nom;
        this.prenom = prenom;
    }
}
