package com.yc.spring.test;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yc.spring.bean.User;

/*  测试
 * 第一种配置基本类型的属性
 * 
 * */
public class PTest {

	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("P.xml");

	@Test
	public void test1() {
		User user = (User) context.getBean("myUser");
		Assert.assertNotNull(user);
		Assert.assertEquals("武松", user.getUname());
		Assert.assertEquals("abc123", user.getUpass());
		
		User p_user = (User) context.getBean("p-user");
		Assert.assertNotNull(p_user);
		Assert.assertEquals("武松", user.getUname());
		Assert.assertEquals("abc123", user.getUpass());
	}
	

	
}
