package com.yc.springmvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 控制器注解，SpringMVC 会扫描到被该注解标注的类，作为控制器 
 */
@Controller
public class HelloAction {
	
	/**
	 * 映射地址（仅参考）：127.0.0.1:8080/工程名/hello 
	 */
	@RequestMapping("hello")
	public String hello(){
		return "hello";
	}

}
