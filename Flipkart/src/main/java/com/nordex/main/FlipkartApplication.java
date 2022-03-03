package com.nordex.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.nordex.model")
@ComponentScan("com.nordex")
@EnableJpaRepositories("com.nordex.repository")
public class FlipkartApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlipkartApplication.class, args);
	}

}
