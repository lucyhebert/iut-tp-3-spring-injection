package edu.lyon1;

import java.util.Objects;
import org.springframework.stereotype.Component;

public class Utilisateur {
    private final String prenom;
    private final String nom;

    public Utilisateur(String prenom, String nom) {
        this.prenom = prenom;
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Utilisateur that = (Utilisateur) o;
        return Objects.equals(prenom, that.prenom) &&
            Objects.equals(nom, that.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prenom, nom);
    }
}
