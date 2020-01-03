package com.yc.springmvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.springmvc.bean.Result;

@Controller
public class ProductesAction {
	
	/**
	 * RequestMapping 注解的 productes 属性配置说明
	 * productes 属性配置应该注意：以下三个内容必须匹配，才能正确的响应
	 * 	1、Accept 的值：			例如：Accept: application/xml, text/xml, ...
	 * 	2、productes 的值：		例如：produces = "application/xml;charset=utf-8"
	 * 	3、控制器方法的返回值：	例如：application/xml 就必须返回 xml格式的字符串
	 * 
	 * 另外：*号作为通配符，在 productes 属性配置不灵光
	 * 	例如：定义A,B 两个方法，示意如下
	 * 		A():application/json
	 * 		B():application/*
	 * 	浏览器发起 ajax 请求，Accept 为：application/xml, text/xml, ...
	 * 	结果 A() 方法接收到了请求，汗。。。
	 */

	@GetMapping(path = { "productes", "p" })
	public String index() {
		return "productes";
	}

	/**
	 * 返回 字符串 数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(path = "productes.do", produces = "text/plain;charset=utf-8")
	public String run1() {
		return "请求报文头域中的 Accept 值包含： text/plain";
	}

	/**
	 * 返回 json 数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(path = "productes.do", produces = "application/json;charset=utf-8")
	public Result run2() {
		return Result.success("请求报文头域中的 Accept 值包含： application/json");
	}
	
	/**
	 * 返回 xml 数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(path = "productes.do", produces = "application/xml;charset=utf-8")
	public String run3() {
		return "<test>请求报文头域中的 Accept 值包含： application/xml</test>";
	}

	/**
	 * 返回 xml 数据，注意 productes 的定义，使用了通配符：*
	 * @return
	 */
	@ResponseBody
	@RequestMapping(path = "productes.do", produces = "application/*;charset=utf-8")
	public String run4() {
		return "<test>请求报文头域中的 Accept 值包含： application/*</test>";
	}

}
