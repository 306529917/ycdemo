package com.yc.C0S3Plycloudindex.web;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class IndexAction {
	// step 1 RestTemplate服务调用
	@Resource
	private RestTemplate restTemplate;
	
	/**
	 * 坑：如果给IOrderAction 对象命名为 orderAction，等着掉坑吧！！
	 * 给我点时间我想静静。。。反思 Autowired 与 Resourse 的区别。。。
	 */
	// step 4 声明式服务调用（Feign）
	@Resource
	private IOrderAction oAction;
	@Resource
	private IUserAction uAction;
	
	@RequestMapping("testUser")
	// step 5 Hystrix服务熔断
	@HystrixCommand(fallbackMethod="fallbackTestUser")
	public String testUser(){
		// step 1 RestTemplate服务调用（IP+端口）
		// String url = "http://127.0.0.1:8003/user/test";
		// step 2 服务注册
		// String url = "http://cloud-user/user/test";
		// return restTemplate.getForObject(url, String.class);
		// step 4  声明式服务调用（Feign）
		return uAction.testUser();
	}
	
	@RequestMapping("testOrder")
	public String testOrder(){
		// step 1 RestTemplate服务调用（IP+端口）
		// String url = "http://127.0.0.1:8002/order/test";
		// step 2 服务注册
		// String url = "http://cloud-order/order/test";
		// return restTemplate.getForObject(url, String.class);
		// step 4  声明式服务调用（Feign）
		return oAction.testOrder();
	}
	
	// step 5
	public String fallbackTestUser(){
		return "user test 暂时不可访问";
	}
	
	@GetMapping({"/","index"})
	public ModelAndView index(){
		return new ModelAndView("redirect:index.html");
	}

}
