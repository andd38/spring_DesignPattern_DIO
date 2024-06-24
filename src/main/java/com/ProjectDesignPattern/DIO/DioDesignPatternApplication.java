package com.ProjectDesignPattern.DIO;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DioDesignPatternApplication {

	public static void main(String[] args) {
		SpringApplication.run(DioDesignPatternApplication.class, args);
	}

}
