<%@page import="java.io.IOException"%>
<%@page import="com.yc.jee.util.WebHelper"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%!public void imgs(String prefix, PageContext pageContext) throws IOException {
		WebHelper.buildHtmlByFiles("<img src='$images/${name}'/><br>", "$images", prefix + "-.+", pageContext);
	}%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<hr>
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

	<hr>
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

	<hr>
	<h3>题目03</h3>
	<p>
		<span style="font-family: 宋体;">实现如下类之间的继承关系，并编写</span><span
			style="font-family: 'Times New Roman';">Music</span><span
			style="font-family: 宋体;">类来测试这些类。</span>
	</p>
	<p>
		<%
			imgs("03", pageContext);
		%>
	</p>

	<hr>
	<h3>题目04</h3>
	<p>
		创建如下三个类：（People类中的三个方法分别输出一些信息，ChinaPeople和AmericanPeople类重写父类的三个方法）。
	</p>
	<p>
		<%
			imgs("04", pageContext);
		%>
	</p>

	<hr>
	<h3>题目05</h3>
	<pre>
编写一个Java应用程序，该程序包括3个类：Monkey类、People类和主类E。要求：

(1) Monkey类中有个构造方法：Monkey (String s)，并且有个public void speak()方法，在speak方法中输出“咿咿呀呀......”的信息。

(2)People类是Monkey类的子类，在People类中重写方法speak(),在speak方法中输出“小样的，不错嘛！会说话了！”的信息。

(3)在People类中新增方法void think()，在think方法中输出“别说话！认真思考！”的信息。

(4)在主类E的main方法中创建Monkey与People类的对象类测试这2个类的功能。
	</pre>
	<p>
		<%
			imgs("05", pageContext);
		%>
	</p>
	
		<hr>
	<h3>题目06</h3>
	<pre>
按要求编写一个Java应用程序：

（1）定义一个类，描述一个矩形，包含有长、宽两种属性，和计算面积方法。

（2）编写一个类，继承自矩形类，同时该类描述长方体，具有长、宽、高属性，和计算体积的方法。

（3）编写一个测试类，对以上两个类进行测试，创建一个长方体，定义其长、宽、高，输出其底面积和体积。
	</pre>
	<p>
		<%
			imgs("06", pageContext);
		%>
	</p>

</body>
</html>