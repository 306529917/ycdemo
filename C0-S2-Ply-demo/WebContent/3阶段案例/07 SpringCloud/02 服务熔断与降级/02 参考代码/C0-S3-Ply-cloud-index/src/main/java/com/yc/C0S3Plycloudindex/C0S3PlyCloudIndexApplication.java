package com.yc.C0S3Plycloudindex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
//step 2
@EnableEurekaClient
//step 4
@EnableFeignClients
//step 5
//@EnableCircuitBreaker
public class C0S3PlyCloudIndexApplication {

	public static void main(String[] args) {
		SpringApplication.run(C0S3PlyCloudIndexApplication.class, args);
	}
	
	// step 1
	@Bean
	// step 2
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
