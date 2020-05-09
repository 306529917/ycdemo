package com.yc.springmvc.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexAction {

	/**
	 * 	打开首页
	 */
	@RequestMapping({ "/", "index" })
	public String index(@RequestParam(defaultValue = "") String order) {
		return "index" + order;
	}
}
