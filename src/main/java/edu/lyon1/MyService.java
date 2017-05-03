package edu.lyon1;

import org.springframework.stereotype.Service;

@Service
public class MyService {

  private final Utilisateur utilisateur;

  public MyService(Utilisateur utilisateur) {
    this.utilisateur = utilisateur;
  }

  public boolean checkUser(Utilisateur utilisateurRequete) {
    return utilisateur.equals(utilisateurRequete);
  }
}
