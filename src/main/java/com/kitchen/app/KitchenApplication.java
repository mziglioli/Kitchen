package com.kitchen.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kitchen.config.database.MongoConfig;
import com.kitchen.config.security.SecurityConfig;
import com.kitchen.config.servlet.ServletContextConfig;
import com.kitchen.exception.GlobalExceptionHandler;
import com.kitchen.security.SecurityPackage;

@SpringBootApplication(scanBasePackageClasses = { MongoConfig.class, SecurityPackage.class, SecurityConfig.class,
		ServletContextConfig.class, GlobalExceptionHandler.class })
public class KitchenApplication {

	public static void main(String[] args) {
		SpringApplication.run(KitchenApplication.class, args);
	}
}