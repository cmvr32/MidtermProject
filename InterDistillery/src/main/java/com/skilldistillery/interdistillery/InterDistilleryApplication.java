package com.skilldistillery.interdistillery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.skilldistillery.interdistillery")
public class InterDistilleryApplication {

	public static void main(String[] args) {
		SpringApplication.run(InterDistilleryApplication.class, args);
	}

}
