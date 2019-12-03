package com.yc.spring.test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yc.spring.dao.UserDao;

/* 测试：
 * 第二种配置引用类型的属性
 * */
public class UserDaoTest {


	@Test
	public void test() {
	
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("p2.xml");
		UserDao userDao1=(UserDao) context.getBean("userDao1");
		UserDao userDao2=(UserDao) context.getBean("userDao2");
		userDao1.test();
		userDao2.test();
	}
}
