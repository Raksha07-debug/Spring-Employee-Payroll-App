package com.example.employeepayrollappdevelopment;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@Slf4j
@SpringBootApplication
public class EmployeepayrollappdevelopmentApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(EmployeepayrollappdevelopmentApplication.class, args);
		log.info("Payroll App  started in '{}' Environment !", context.getEnvironment().getProperty("environment"));
		log.info("Employee payroll DB user is {}", context.getEnvironment().getProperty("spring.datasource.username"));
	}

}
