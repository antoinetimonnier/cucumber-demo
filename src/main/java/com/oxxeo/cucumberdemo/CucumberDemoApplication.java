package com.oxxeo.cucumberdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class CucumberDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CucumberDemoApplication.class, args);
	}

}
