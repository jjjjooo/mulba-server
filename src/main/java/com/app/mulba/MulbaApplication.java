package com.app.mulba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class MulbaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MulbaApplication.class, args);
	}

}
