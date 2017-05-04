package edu.lyon1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

/**
 * Created by p1614402 on 04/05/2017.
 */

@Component
@ConfigurationProperties(prefix="utilisateurs")
public class ListeUtilisateurs {


}
