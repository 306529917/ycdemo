package com.yc.demo.aop.mybatis.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.yc.demo.aop.mybatis.SqlSession;
import com.yc.demo.aop.mybatis.bean.Student;

public class StudentMapperTest {

	@Test
	public void test() {
		SqlSession session = new SqlSession();

		StudentMapper sm = session.getMapper(StudentMapper.class);
		
		sm.deleteAll();
		
		List<Student> list = sm.selectAll();
		Assert.assertEquals(0, list.size());
		
		sm.insert(new Student("1","武松",25,3));
		sm.insert(new Student("2","林冲",28,3));
		sm.insert(new Student("3","鲁达",26,3));
		sm.insert(new Student("4","花荣",22,3));
		
		list = sm.selectAll();
		Assert.assertEquals(4, list.size());
		
		Student s = sm.selectBySn("1");
		Assert.assertEquals("武松", s.getName());
		Assert.assertEquals(25, s.getAge());
		
		s.setName("宋江");
		s.setAge(10);
		sm.update(s);
		
		s = sm.selectBySn("1");
		Assert.assertEquals("宋江", s.getName());
		Assert.assertEquals(10, s.getAge());
	}

}
