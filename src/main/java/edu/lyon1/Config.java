package edu.lyon1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by p1614402 on 04/05/2017.
 */

@Configuration
public class Config {

    @Bean(name="utilisateur")
    public Utilisateur utilisateur() {
        return new Utilisateur();
    }

    @Bean(name="utilisateurs")
    public Collection<Utilisateur> listeUtilisateurs() {
        Collection<Utilisateur> users = new ArrayList<>();

        users.add(new Utilisateur("Homer", "Simpson"));
        users.add(new Utilisateur("John", "Doe"));
        users.add(new Utilisateur("Blah", "Blah"));

        return users;
    }


}
