package com.yc.demo.aop.mybatis.dao;

import java.util.List;

import com.yc.demo.aop.mybatis.anno.Insert;
import com.yc.demo.aop.mybatis.anno.Select;
import com.yc.demo.aop.mybatis.anno.Update;
import com.yc.demo.aop.mybatis.bean.Student;

public interface StudentMapper {
	
	@Select("select * from student where sn = #{sn}")
	public Student selectBySn(String sn);
	
	@Select("select * from student")
	public List<Student> selectAll();
	
	@Select("delete from student")
	public void deleteAll();
	
	@Update("update student set name=#{name}, age=#{age}, grade=#{grade} where sn=#{sn}")
	public void update(Student student);
	
	@Insert("insert into student values(#{sn},#{name},age=#{age},grade=#{grade})")
	public void insert(Student student);
	
	

}
