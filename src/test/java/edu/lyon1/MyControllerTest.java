package edu.lyon1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class MyControllerTest {

  public static final Utilisateur UTILISATEUR = new Utilisateur("John", "Doe");

  @Test
  public void controllerShouldReturnTrueWhenServiceCheckIsTrue(){
    MyService service = mock(MyService.class);
    when(service.checkUser(UTILISATEUR)).thenReturn(true);
    MyController controller = new MyController(service);
    Boolean result = controller.utilisateur("John", "Doe");
    assertThat(result).isTrue();
  }

  @Test
  public void controllerShouldReturnFalseWhenServiceCheckIsFalse(){
    MyService service = mock(MyService.class);
    when(service.checkUser(UTILISATEUR)).thenReturn(false);
    MyController controller = new MyController(service);
    Boolean result = controller.utilisateur("John", "Doe");
    assertThat(result).isFalse();
  }

}