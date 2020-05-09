package com.yc.C0S3Plycloudorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
// step 2
@EnableEurekaClient
public class C0S3PlyCloudOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(C0S3PlyCloudOrderApplication.class, args);
	}

}
