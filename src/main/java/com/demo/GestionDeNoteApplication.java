package com.demo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.demo.entity.Etudiant;

@SpringBootApplication
@Configuration
@ComponentScan("com.demo.services")
@ComponentScan("com.demo")
@EnableAutoConfiguration
@EntityScan("com.demo.entity") // path of the entity model
@EnableJpaRepositories("com.demo.repository") // path of jpa repository 
public class GestionDeNoteApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionDeNoteApplication.class, args);
		
	}

}
