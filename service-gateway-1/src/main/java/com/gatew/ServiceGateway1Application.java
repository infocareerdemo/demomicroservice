package com.gatew;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;

@SpringBootApplication
public class ServiceGateway1Application {

	public static void main(String[] args) {
		SpringApplication.run(ServiceGateway1Application.class, args);
	}

}
