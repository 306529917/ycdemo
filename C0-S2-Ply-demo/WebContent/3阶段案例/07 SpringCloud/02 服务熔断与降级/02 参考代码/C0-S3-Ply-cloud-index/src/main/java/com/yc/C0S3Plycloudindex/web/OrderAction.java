package com.yc.C0S3Plycloudindex.web;

import org.springframework.stereotype.Component;

//step 6 Feign服务熔断
@Component
public class OrderAction implements IOrderAction{

	public String testOrder(){
		return "order test 暂时不可访问";
	}

}
