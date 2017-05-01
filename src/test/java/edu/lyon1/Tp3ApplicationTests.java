package edu.lyon1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Tp3ApplicationTests {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void contextLoads() {
    }

    @Test
    public void shouldContainAService() {
        Map<String, Object> beansWithServiceAnnotation = applicationContext.getBeansWithAnnotation(Service.class);
        assertThat(beansWithServiceAnnotation).isNotEmpty();
    }

    @Test
    public void shouldContainAConfiguration() {
        Map<String, Object> beansWithConfigurationAnnotation = applicationContext.getBeansWithAnnotation(Configuration.class);
        boolean hasConfiguration = beansWithConfigurationAnnotation.values().stream()
                .map(bean -> bean.getClass().getName())
                .filter(name -> name.startsWith("edu.lyon1"))
                .anyMatch(name -> !name.contains("Tp3Application"));
        assertThat(hasConfiguration).isTrue();
    }

}
