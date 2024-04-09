package com.danielfreitas.exercicio05;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Execicio intermediario",version = "1", description = "Api desnvolvida para materia de backend"))
public class Exercicio05Application {

	public static void main(String[] args) {
		SpringApplication.run(Exercicio05Application.class, args);
	}

}
