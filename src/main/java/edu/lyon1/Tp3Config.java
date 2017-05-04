package edu.lyon1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by p1614402 on 04/05/2017.
 */

@Configuration
public class Tp3Config {

    @Bean(name="nom")
    public String nom() {
        return "Simpson";
    }

    @Bean(name="prenom")
    public String prenom() {
        return "Homer";
    }

    @Bean(name="utilisateur")
    public Utilisateur utilisateur() {
        return new Utilisateur();
    }
}
