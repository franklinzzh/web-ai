package com.franklin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebAiApplication {

	public static void main(String[] args) {
        System.out.println("=== APPLICATION YML LOADED ===");
        SpringApplication.run(WebAiApplication.class, args);
	}

}
