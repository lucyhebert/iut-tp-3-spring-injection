package edu.lyon1;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by p1614402 on 04/05/2017.
 */

public class Utilisateur {

    @Autowired
    String nom;

    @Autowired
    String prenom;

    public Utilisateur() {
        this.nom = nom;
        this.prenom = prenom;
    }
}
