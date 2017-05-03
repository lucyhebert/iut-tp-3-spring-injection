package edu.lyon1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    private final MyService myService;

    public MyController(MyService myService) {
        this.myService = myService;
    }

    @RequestMapping("/")
    public Boolean utilisateur(
            @RequestParam(value = "prenom", defaultValue = "") String prenom,
            @RequestParam(value = "nom", defaultValue = "") String nom) {
        return myService.checkUser(new Utilisateur(prenom,nom));
    }
}
