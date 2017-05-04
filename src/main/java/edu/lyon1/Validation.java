package edu.lyon1;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

/**
 * Created by p1614402 on 04/05/2017.
 */
public class Validation {

    @Autowired
    public Collection<Utilisateur> utilisateurs;

    private boolean status;
    private String message;
    private Utilisateur user;

    public Validation(Utilisateur user) {
        this.user = user;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Utilisateur getUser() {
        return user;
    }

    public void checkUser() {
        if(!utilisateurs.contains(this.getUser())) {
            this.setStatus(false);
            this.setMessage("nom et/ou prenom non compatibles");
        }
        else {
            this.setStatus(true);
        }
    }
}
