package com.yc.mock.dao;

import com.yc.mock.bean.User;

public interface UserDao {
	
	User selectByLogin(String name, String pwd);

}
