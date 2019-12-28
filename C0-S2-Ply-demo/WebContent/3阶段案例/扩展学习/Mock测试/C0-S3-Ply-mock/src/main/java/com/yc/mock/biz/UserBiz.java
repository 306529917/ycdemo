package com.yc.mock.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.mock.bean.User;
import com.yc.mock.dao.UserDao;

@Service
public class UserBiz {

	@Resource
	private UserDao udao;

	public User login(String name, String pwd) throws BizException {
		if (name == null || name.trim().isEmpty()) {
			throw new BizException("请填写用户名！");
		}
		if (pwd == null || pwd.trim().isEmpty()) {
			throw new BizException("请填写密码！");
		}
		User user = udao.selectByLogin(name, pwd);
		if (user == null) {
			throw new BizException("用户名或密码错误");
		}
		return user;
	}

}
