package com.alurachallenge.aluraflix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
	
@SpringBootApplication
@EntityScan("com.alurachallenge.aluraflix.entities")
public class AluraflixApplication {

	public static void main(String[] args) {
		SpringApplication.run(AluraflixApplication.class, args);
	}

}
