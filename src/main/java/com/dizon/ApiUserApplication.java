package com.dizon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiUserApplication {

	public static void main(String[] args) {
		//SpringApplication.run(ApiUserApplication.class, args);
		
		SpringApplication app = new SpringApplication(ApiUserApplication.class);

		System.out.println("\n ==== Api-User running ====");

		app.run(args);
	}

}
