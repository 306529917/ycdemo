package com.yc.C0S3Plythymeleaf.web;

import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.yc.C0S3Plythymeleaf.bean.User;

@Controller
@SessionAttributes("loginedUser")
public class IndexAction {

	// 模拟数据库
	private static final Set<User> USER_DATABASE = new HashSet<>();

	@ModelAttribute
	public User setup() {
		return new User();
	}

	@GetMapping({ "/", "login" })
	public String tologin(Model m) {
		return "login";
	}

	@GetMapping({ "reg" })
	public String toreg(Model m) {
		m.addAttribute("likes", new String[] { "读书", "电影", "打球" });
		return "register";
	}

	@PostMapping("doreg")
	public String doreg(@ModelAttribute @Valid User user, Errors es, Model m) {
		if (es.hasErrors()) {
			return toreg(m);
		} else {
			USER_DATABASE.add(user);
			return tologin(m);
		}
	}

	@PostMapping("dologin")
	public String dologin(@ModelAttribute @Valid User user, Errors es, Model m) {
		for (User u : USER_DATABASE) {
			if (u.getPhone().equals(user.getPhone()) && u.getPwd().equals(user.getPwd())) {
				m.addAttribute("loginedUser", u);
				return tologin(m);
			}
		}
		m.addAttribute("msg","用户名或密码错误！");
		return tologin(m);
	}
}
