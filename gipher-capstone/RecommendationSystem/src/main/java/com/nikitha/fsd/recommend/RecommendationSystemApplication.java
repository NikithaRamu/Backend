package com.nikitha.fsd.recommend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RecommendationSystemApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(RecommendationSystemApplication.class, args);
	    System.out.println("hello kafka consumer ");

	}

}
