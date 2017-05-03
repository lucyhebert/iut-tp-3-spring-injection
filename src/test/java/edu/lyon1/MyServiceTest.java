package edu.lyon1;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class MyServiceTest {

  public static final String PRENOM = "prenom";
  public static final String NOM = "nom";
  public static final String AUTRE_PRENOM = "autrePrenom";
  public static final String AUTRE_NOM = "autreNom";

  @Test
  public void checkShouldBeFalseForUserWithDeferentFirstAndLastName(){
    MyService service = new MyService(new Utilisateur(PRENOM, NOM));
    boolean check = service.checkUser(new Utilisateur(AUTRE_PRENOM, AUTRE_NOM));
    assertThat(check).isFalse();
  }

  @Test
  public void checkShouldBeFalseForUserWithDeferentFirstName(){
    MyService service = new MyService(new Utilisateur(PRENOM, NOM));
    boolean check = service.checkUser(new Utilisateur(AUTRE_PRENOM, NOM));
    assertThat(check).isFalse();
  }

  @Test
  public void checkShouldBeFalseForUserWithDeferentLastName(){
    MyService service = new MyService(new Utilisateur(PRENOM, NOM));
    boolean check = service.checkUser(new Utilisateur(PRENOM, AUTRE_NOM));
    assertThat(check).isFalse();
  }

  @Test
  public void checkShouldBeTrueForUserWithSameFirstAndLastName(){
    MyService service = new MyService(new Utilisateur(PRENOM, NOM));
    boolean check = service.checkUser(new Utilisateur(PRENOM, AUTRE_NOM));
    assertThat(check).isFalse();
  }

}