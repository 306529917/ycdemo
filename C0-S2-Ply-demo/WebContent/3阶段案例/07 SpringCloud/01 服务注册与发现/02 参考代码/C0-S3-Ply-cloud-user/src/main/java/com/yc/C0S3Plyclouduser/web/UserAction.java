package com.yc.C0S3Plyclouduser.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserAction {

	@RequestMapping("user/test")
	public String test(HttpServletRequest req){
		return "UserAction.test " + req.getLocalPort();
	}
}
