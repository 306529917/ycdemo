package com.yc.mock.dao;

import org.springframework.stereotype.Repository;

import com.yc.mock.bean.User;

@Repository
public class UserDaoImpl implements UserDao {

	public User selectByLogin(String name, String pwd) {
		return null;
	}

}
