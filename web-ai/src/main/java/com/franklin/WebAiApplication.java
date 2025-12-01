package com.franklin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@ConfigurationPropertiesScan
@ServletComponentScan
@SpringBootApplication
@EnableAsync
public class WebAiApplication {

	public static void main(String[] args) {
        System.out.println("=== APPLICATION YML LOADED ===");
        SpringApplication.run(WebAiApplication.class, args);
	}

}
