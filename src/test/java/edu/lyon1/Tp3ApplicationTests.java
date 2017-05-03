package edu.lyon1;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class Tp3ApplicationTests {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

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

    @Test
    public void shouldContainLastNameBean() {
        assertThat(applicationContext.getBean("nom").getClass()).isEqualTo(String.class);
        assertThat((String) applicationContext.getBean("nom")).isEqualTo("Simpson");
    }

    @Test
    public void shouldContainFirstNameBean() {
        assertThat(applicationContext.getBean("prenom").getClass()).isEqualTo(String.class);
        assertThat((String) applicationContext.getBean("prenom")).isEqualTo("Homer");
    }

    @Test
    public void shouldContainUserBean() {
        assertThat(applicationContext.getBean("utilisateur").getClass().getName()).isEqualTo("edu.lyon1.Utilisateur");
        Map<String, Object> beansWithComponentAnnotation = applicationContext.getBeansWithAnnotation(Component.class);
        assertThat(beansWithComponentAnnotation.keySet()).doesNotContain("utilisateur");
        assertThat(applicationContext.getBean("utilisateur"))
                .extracting("prenom")
                .containsExactly("Homer");
        assertThat(applicationContext.getBean("utilisateur"))
                .extracting("nom")
                .containsExactly("Simpson");
    }

    @Test
    public void userCheckShouldBeFalseWhenNoUser() throws Exception {
        this.mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().string(Boolean.FALSE.toString()));
    }

    @Test
    public void userCheckShouldBeFalseWhenWrongUser() throws Exception {
        this.mockMvc.perform(
                get("/")
                        .param("prenom", "Michel")
                        .param("nom", "Sardou")
        )
                .andExpect(status().isOk())
                .andExpect(content().string(Boolean.FALSE.toString()));
    }

    @Test
    public void userCheckShouldBeTrueWhenCorrectUser() throws Exception {
        this.mockMvc.perform(
                get("/")
                        .param("prenom", "Homer")
                        .param("nom", "Simpson")
        )
                .andExpect(status().isOk())
                .andExpect(content().string(Boolean.TRUE.toString()));
    }

}
