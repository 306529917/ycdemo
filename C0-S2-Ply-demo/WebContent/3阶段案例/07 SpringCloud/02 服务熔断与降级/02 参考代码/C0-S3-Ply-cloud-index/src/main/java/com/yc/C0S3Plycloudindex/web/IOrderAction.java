package com.yc.C0S3Plycloudindex.web;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="cloud-order")
public interface IOrderAction {

	@GetMapping("order/test")
	public String testOrder();
	
}
