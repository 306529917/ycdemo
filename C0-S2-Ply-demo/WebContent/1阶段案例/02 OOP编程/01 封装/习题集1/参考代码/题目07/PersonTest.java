package com.yc.java.d1220;

/**
7、写一个类Person,包含以下属性：
	String name; 
	int age; 
	String gender;   
	Person partner。
为Person类写一个marry(Person  p)方法，代表当前对象和p结婚，
如若可以结婚，则输出恭贺信息，否则输出不能结婚原因。
要求在另外一个类中写一个主方法，来测试以上程序。
（下列情况不能结婚：
	1，同性； 
	2，未达到结婚年龄，男<24，女<22；
	3，某一方已婚）
 */
public class PersonTest {
	
	public static void main(String[] args) {
		Person p1 = new Person("武松",25,"男",null);
		Person p2 = new Person("宋江",40,"男",null);
		Person p3 = new Person("阎婆惜",22,"女",p2);
		p2.setPartner(p3);
		Person p4 = new Person("扈三娘",20,"女",null);
		Person p5 = new Person("林黛玉",23,"女",null);
		
		
		p1.marry(p2);
		p1.marry(p3);
		p1.marry(p4);
		p1.marry(p5);
		
		p2.marry(p2);
		p2.marry(p1);
		p2.marry(p3);
		p2.marry(p4);
		
		p4.marry(p1);
		p4.marry(p2);
		p4.marry(p3);
		p4.marry(p5);
		
	}

}
