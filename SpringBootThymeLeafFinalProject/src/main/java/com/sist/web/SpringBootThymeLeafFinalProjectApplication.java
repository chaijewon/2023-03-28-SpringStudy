package com.sist.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.sist.web.controller","com.sist.web.dao"})
public class SpringBootThymeLeafFinalProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootThymeLeafFinalProjectApplication.class, args);
	}

}
