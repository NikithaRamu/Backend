package com.nikitha.fsd.gipher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class GipherManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GipherManagerApplication.class, args);
	    System.out.println("hello gipher manager");

	}

}
