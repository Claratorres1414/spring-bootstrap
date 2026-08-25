package com.starter.spring_bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringBootstrapApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootstrapApplication.class, args);
	}

}
