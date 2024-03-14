package com.pfeffer.anotaaicatalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class AnotaAiCatalogApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnotaAiCatalogApplication.class, args);
	}

}
