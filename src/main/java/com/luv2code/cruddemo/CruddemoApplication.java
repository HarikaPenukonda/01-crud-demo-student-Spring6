package com.luv2code.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(){
		// The CommandLineRunner is from the Spring Boot Framework, Executed after the Spring Beans have been loaded
		// Java Lambda Expression
		return runner -> {
			System.out.println("Hello world");
		};

	}

}
