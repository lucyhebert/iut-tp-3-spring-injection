package edu.lyon1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by p1614402 on 04/05/2017.
 */

@Controller
public class MyController {

    @Autowired
    public MyService service;

    public MyController(MyService service) {
        this.service = service;
    }

    @RequestMapping(value="/", method= RequestMethod.GET)
    @ResponseBody
    public boolean utilisateur(@RequestParam(name="prenom",defaultValue = "pouët") String prenom,
                             @RequestParam(name="nom", defaultValue = "pouët") String nom) {
        return service.checkUser(new Utilisateur(prenom, nom));
    }
}
