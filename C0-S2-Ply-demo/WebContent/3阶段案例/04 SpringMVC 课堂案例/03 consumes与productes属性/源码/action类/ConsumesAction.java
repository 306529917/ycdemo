package com.yc.springmvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ConsumesAction {
	
	@GetMapping(path= {"c.do","c"})
	public String index() {
		return "consumes";
	}
	
	/**
	 * produces = "text/html;charset=utf-8" 用于解决乱码问题
	 */
	@ResponseBody
	@RequestMapping(path = "consumes.do",consumes = {}, produces = "text/html;charset=utf-8")
	public String run() {
		return "请求报文头域不包含 ContextType 字段";
	}

	@ResponseBody
	@RequestMapping(path = "consumes.do", consumes = "application/x-www-form-urlencoded", produces = "text/html;charset=utf-8")
	public String run1() {
		return "请求报文头域中的 ContextType 值为 application/x-www-form-urlencoded";
	}

	@ResponseBody
	@RequestMapping(path = "consumes.do", consumes = "multipart/form-data", produces = "text/html;charset=utf-8")
	public String run2() {
		return "请求报文头域中的 ContextType 值为 multipart/form-data";
	}
	
}
