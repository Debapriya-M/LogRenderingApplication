package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan("com.example.demo.service")
public class LogFileRenderingApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogFileRenderingApplication.class, args);
	}

}
