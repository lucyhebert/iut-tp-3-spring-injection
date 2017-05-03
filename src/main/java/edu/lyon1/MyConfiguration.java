package edu.lyon1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {

  @Bean
  public Utilisateur utilisateur(@Value("${prenom}") String prenom, @Value("${nom}") String nom) {
    return new Utilisateur(prenom, nom);
  }
}
