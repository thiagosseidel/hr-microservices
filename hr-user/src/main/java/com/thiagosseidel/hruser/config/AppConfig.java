package com.thiagosseidel.hruser.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class AppConfig {

	public AppConfig() {
		super();
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEnconder() {
		return new BCryptPasswordEncoder();
	}
}
