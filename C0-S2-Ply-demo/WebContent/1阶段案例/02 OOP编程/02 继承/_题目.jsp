<%@page import="java.io.IOException"%>
<%@page import="com.yc.jee.util.WebHelper"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%!
public void imgs(String prefix, PageContext pageContext)throws IOException{
	WebHelper.buildHtmlByFiles("<img src='$images/${name}'/><br>", "$images", prefix + "-.+", pageContext);
}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>题目01</h3>
	<pre>
实例需求：实现一个名为Person（人）的类和它的子类Employee（员工），Manager（经理）是Employee的子类，设计一 个类Add()用于涨工资，普通员工一次能涨10%，经理能涨20%。
具体要求如下:
（1）Person类
		属性有：姓名name String（类型），地址address（String类型），定义该类的构造方法；
（2）Employee类继承Person类
		扩展新属性：工号ID（String类型)，工资wage（double类型），工龄（int 型），定义该类的构造方法；
		定义 add 方法， 让其加薪幅度达到 10%
（3）Manager类
		重写 add 方法， 让其加薪幅度达到 20%
（4）测试类Test
		产生一个员工和一个经理，给该员工和经理涨工资。
</pre>


	<h3>题目02</h3>
	<pre>
已知有动物类：
	动物属性:毛的颜色（颜色可以任意指定）,腿的个数（数量不可改变）
	行为:吃东西
定义以下几个类
猫类
	腿的数量：4
	特有行为:抓老鼠catchMouse、猫吃鱼
狗类
	腿的数量：4
	特有行为:看家lookHome、狗啃骨头
鹦鹉：
	腿的数量：2
	特有行为:说话talk、鹦鹉吃玉米
章鱼：
	腿的数量：8
	特有行为:游泳k、章鱼吃虾米
</pre>

	<h3>题目03</h3>
	<p>
		<span style="font-family: 宋体;">实现如下类之间的继承关系，并编写</span><span
			style="font-family: 'Times New Roman';">Music</span><span
			style="font-family: 宋体;">类来测试这些类。</span>
	</p>
	<p>
		<% imgs("03", pageContext); %>
	</p>

	<h3>题目03</h3>
	<p>
		创建如下三个类：（People类中的三个方法分别输出一些信息，ChinaPeople和AmericanPeople类重写父类的三个方法）。
	</p>
	<p>
		<% imgs("04", pageContext); %>
	</p>



</body>
</html>