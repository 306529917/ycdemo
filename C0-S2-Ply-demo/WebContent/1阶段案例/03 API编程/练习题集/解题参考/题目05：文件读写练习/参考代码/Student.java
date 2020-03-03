package com.yc.api.io;

public class Student {
	
	private String sn; 		// 学号
	private	String name; 	// 姓名
	private int	   chinese;	// 语文成绩
	private int    math;	// 数学成绩
	private	int	   physics;	// 物理成绩
	
	public String getSn() {
		return sn;
	}


	public void setSn(String sn) {
		this.sn = sn;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getChinese() {
		return chinese;
	}


	public void setChinese(int chinese) {
		this.chinese = chinese;
	}


	public int getMath() {
		return math;
	}


	public void setMath(int math) {
		this.math = math;
	}


	public int getPhysics() {
		return physics;
	}


	public void setPhysics(int physics) {
		this.physics = physics;
	}
	
}
