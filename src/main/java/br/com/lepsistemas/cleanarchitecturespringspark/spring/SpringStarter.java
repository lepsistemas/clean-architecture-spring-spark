package br.com.lepsistemas.cleanarchitecturespringspark.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

import br.com.lepsistemas.cleanarchitecturespringspark.application.starter.StarterStrategy;

@SpringBootApplication
@PropertySource("classpath:spring.properties")
public class SpringStarter implements StarterStrategy {
	
	@Override
	public void run(String[] args) {
		SpringApplication.run(SpringStarter.class, args);
	}

}
