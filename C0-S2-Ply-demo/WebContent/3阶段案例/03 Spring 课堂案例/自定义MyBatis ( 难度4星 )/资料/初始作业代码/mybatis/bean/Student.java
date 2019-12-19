package com.yc.demo.aop.mybatis.bean;

/**
 * 学生类
 */
public class Student {
	
	private String sn;
	private String name;
	private int age;
	private int grade;
	
	public Student() {}
	
	public Student(String sn, String name, int age, int grade) {
		super();
		this.sn = sn;
		this.name = name;
		this.age = age;
		this.grade = grade;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	
}
