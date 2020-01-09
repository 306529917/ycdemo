package com.yc.C0S3Plycloudindex.web;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class IndexAction {
	
	@Resource
	private RestTemplate restTemplate;

	@RequestMapping("testUser")
	//@HystrixCommand(fallbackMethod="wayHystirx")
	public String testUser(){
		// step 1
		// String url = "http://127.0.0.1:8003/user/test";
		// step 2
		String url = "http://cloud-user/user/test";
		return restTemplate.getForObject(url, String.class);
	}
	
	@RequestMapping("testOrder")
	public String testOrder(){
		// step 1
		// String url = "http://127.0.0.1:8002/order/test";
		// step 2
		String url = "http://cloud-order/order/test";
		return restTemplate.getForObject(url, String.class);
	}
	
	
}
