package com.yc.C0S3Plycloudorder.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderAction {

	@RequestMapping("order/test")
	public String test(){
		return "OrderAction.test";
	}
}
