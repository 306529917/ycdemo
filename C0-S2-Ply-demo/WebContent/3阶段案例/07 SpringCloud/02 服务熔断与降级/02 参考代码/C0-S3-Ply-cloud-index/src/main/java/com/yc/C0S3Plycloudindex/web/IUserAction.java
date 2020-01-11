package com.yc.C0S3Plycloudindex.web;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

//step 4 声明式服务调用（Feign）
@FeignClient(name = "cloud-user")
public interface IUserAction {

	@GetMapping("user/test")
	public String testUser();

}
