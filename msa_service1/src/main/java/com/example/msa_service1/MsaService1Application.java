package com.example.msa_service1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MsaService1Application {

	public static void main(String[] args) {
		SpringApplication.run(MsaService1Application.class, args);
	}

}
