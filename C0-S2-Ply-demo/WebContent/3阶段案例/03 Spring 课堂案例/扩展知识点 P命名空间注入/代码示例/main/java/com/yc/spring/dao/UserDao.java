package com.yc.spring.dao;

import com.yc.spring.bean.User;

public class UserDao {

	private User user;

	public void test() {
		System.out.println("用户名:"+user.getUname()+"     密码:"+user.getUpass());
	}

	public UserDao() {
		super();
	}

	public UserDao(User user) {
		super();
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
