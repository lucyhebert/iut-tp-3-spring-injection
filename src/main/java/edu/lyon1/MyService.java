package edu.lyon1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by p1614402 on 04/05/2017.
 */

@Service
public class MyService {

    @Autowired
    private Utilisateur utilisateur;

    @Autowired
    private Collection<Utilisateur> utilisateurs;

    public MyService(Utilisateur user) {

        this.utilisateur = user;
    }

    public boolean checkUser(Utilisateur user) {

        return utilisateur.equals(user);
    }

    public boolean checkUserInList(Utilisateur user) {
        return utilisateurs.contains(user);
    }
}
