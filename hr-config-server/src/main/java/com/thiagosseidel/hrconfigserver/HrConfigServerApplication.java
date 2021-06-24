package com.thiagosseidel.hrconfigserver;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class HrConfigServerApplication implements CommandLineRunner {

	/*@Value("${spring.cloud.config.server.git.username}")
	private String userName;
	
	@Value("${spring.cloud.config.server.git.password}")
	private String passWord;*/
	
	public static void main(String[] args) {
		SpringApplication.run(HrConfigServerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		/*System.out.println("USER_NAME = " + userName);
		
		System.out.println("PASSWORD = " + passWord);*/
		
	}

}
