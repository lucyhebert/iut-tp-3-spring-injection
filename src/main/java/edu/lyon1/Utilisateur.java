package edu.lyon1;

import org.springframework.beans.factory.annotation.Value;

import java.util.Objects;

/**
 * Created by p1614402 on 04/05/2017.
 */

public class Utilisateur {

    @Value("${nom}")
    private String nom;

    @Value("${prenom}")
    private String prenom;

    private String mail;

    public Utilisateur() {
        this.nom = nom;
        this.prenom = prenom;
    }

    public Utilisateur(String firstName, String name) {
        this.nom = name;
        this.prenom = firstName;
    }

    public Utilisateur(String firstName, String name, String mail) {
        this.nom = name;
        this.prenom = firstName;
        this.mail = mail;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Utilisateur that = (Utilisateur) o;
        return Objects.equals(nom, that.nom) &&
                Objects.equals(prenom, that.prenom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, prenom);
    }
}
