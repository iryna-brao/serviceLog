package com.example.service_log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServiceLogApplication {

	// Правильний тип Logger із SLF4J
	private static final Logger logger = LoggerFactory.getLogger(ServiceLogApplication.class);

	public static void main(String[] args) {
		logger.info("Starting ServiceLogApplication...");
		SpringApplication.run(ServiceLogApplication.class, args);
	}
}
