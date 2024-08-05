package com.bangez.land;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class LandApplication {

	public static void main(String[] args) {
		SpringApplication.run(LandApplication.class, args);
	}

}
