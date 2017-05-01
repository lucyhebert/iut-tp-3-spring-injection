package edu.lyon1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
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
	public void shouldContainAService(){
		Map<String, Object> beansWithServiceAnnotation = applicationContext.getBeansWithAnnotation(Service.class);
		assertThat(beansWithServiceAnnotation).isNotEmpty();
	}

}
