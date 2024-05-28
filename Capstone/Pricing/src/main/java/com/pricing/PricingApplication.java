package com.pricing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class PricingApplication {

	public static void main(String[] args) {
		SpringApplication.run(PricingApplication.class, args);
	}

}
