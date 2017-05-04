package edu.lyon1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by p1614402 on 04/05/2017.
 */

@Component(value="utilisateur")
public class Utilisateur {

    @Autowired
    String nom;

    @Autowired
    String prenom;
    
}
