package com.yc.mock;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.yc.mock.bean.User;
import com.yc.mock.biz.BizException;
import com.yc.mock.biz.UserBiz;
import com.yc.mock.dao.UserDao;

@RunWith(SpringRunner.class)
@ContextConfiguration("/beans.xml")
public class DemoTest {

	/**
	 * SpringBoot 环境下只需要使用 @MockBean 即可代替：
	 * 	1、@Mock
	 * 	2、@InjectMocks
	 * 	3、MockitoAnnotations.initMocks(this); // Mock初始化
	 */
	@Mock
	private UserDao udao;

	@InjectMocks
	@Resource
	private UserBiz ubiz;

	/**
	 * 注意：必须加上该方法，否则 udao 为空
	 */
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this); // Mock初始化
		/**
		 * 打桩（返回值设定）
		 */
		Mockito.when(udao.selectByLogin("root", "123")).thenReturn(new User());
		Mockito.when(udao.selectByLogin("admin", "a")).thenReturn(new User());
		//参数值匹配模式，不允许："test", Mockito.anyString()
		Mockito.when(udao.selectByLogin(Mockito.eq("test"), Mockito.anyString())).thenReturn(new User());
	}

	@Test
	public void testLogin() {
		try {
			User user = ubiz.login("root", "123");
			user = ubiz.login("admin", "a");
			user = ubiz.login("admin", "a");
			user = ubiz.login("admin", "a");
			user = ubiz.login("admin", "a");
			user = ubiz.login("test", "123");
			user = ubiz.login("test", "123");
			user = ubiz.login("test", "123");
			user = ubiz.login("test", "a");
			user = ubiz.login("test", "a");
			user = ubiz.login("test", "a");
			user = ubiz.login("test", "a");
			
			/**
			 * 行为验证
			 */
			Mockito.verify(udao).selectByLogin("root", "123");
			// times == 4
			Mockito.verify(udao, Mockito.times(4)).selectByLogin("admin", "a");
			// times >= 2
			Mockito.verify(udao, Mockito.atLeast(2)).selectByLogin("test", "123");
			// times <= 5
			Mockito.verify(udao, Mockito.atMost(5)).selectByLogin("test", "a");
			Assert.assertNotNull(user);
		} catch (BizException e) {
			throw new RuntimeException(e);
		}

		try {
			ubiz.login("root", "a");
		} catch (BizException e) {
			Assert.assertEquals("用户名或密码错误", e.getMessage());
		}

		try {
			ubiz.login("", "???");
		} catch (BizException e) {
			Assert.assertEquals("请填写用户名！", e.getMessage());
		}
		
		try {
			ubiz.login("test", "");
		} catch (BizException e) {
			Assert.assertEquals("请填写密码！", e.getMessage());
		}
	}

}
