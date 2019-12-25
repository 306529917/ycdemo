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


	<hr>
	<h3>题目07</h3>
	<p>
		编写一个Java应用程序，设计一个汽车类Vehicle，包含的属性有车轮个数wheels和车重weight。小车类Car是Vehicle的子类，其中包含的属性有载人数loader。卡车类Truck是Car类的子类，其中包含的属性有载重量payload。每个类都有构造方法和输出相关数据的方法。最后，写一个测试类来测试这些类的功能。
	</p>
	<p>
		<%
			imgs("07", pageContext);
		%>
	</p>


	<hr>
	<h3>题目08</h3>
	<p>
		编写一个Shape类，具有属性：周长和面积；定义其子类三角形和矩形，分别具有求周长的方法。定义主类E，在其main方法中创建三角形和矩形类的对象，并赋给Shape类的对象a、b，使用对象a、b来测试其特性。
	</p>
	<p>
		<%
			imgs("08", pageContext);
		%>
	</p>


	<hr>
	<h3>题目09</h3>
	<pre>
实现一个名为Person的类和它的子类Employee，Employee有两个子类Faculty和Staff。具体要求如下：

（1）Person类中的属性有：姓名name（String类型），地址address（String类型），电话号码telphone（String类型）和电子邮件地址email（String类型）；

（2）Employee类中的属性有：办公室office（String类型），工资wage（double类型），受雇日期hiredate（String类型）；

（3）Faculty类中的属性有：学位degree（String类型），级别level（String类型）；

（4）Staff类中的属性有：职务称号duty（String类型）。	</pre>
	<p>
		<%
			imgs("09", pageContext);
		%>
	</p>


	<hr>
	<h3>题目10</h3>
	<p>
编写一个Car类，具有String类型的属性品牌，具有功能drive；定义其子类Aodi和Benchi，具有属性：价格、型号；具有功能：变速；定义主类E，在其main方法中分别创建Aodi和Benchi的对象并测试对象的特性。
	</p>
	<p>
		<%
			imgs("10", pageContext);
		%>
	</p>
	
	
	<hr>
	<h3>题目11</h3>
	<pre>
按要求编写一个Java应用程序：

（1）编写一个矩形类Rect，包含：

两个属性：矩形的宽width；矩形的高height。

两个构造方法：

1．一个带有两个参数的构造方法，用于将width和height属性初化；

2．一个不带参数的构造方法，将矩形初始化为宽和高都为10。

两个方法：

求矩形面积的方法area()

求矩形周长的方法perimeter()

（2）通过继承Rect类编写一个具有确定位置的矩形类PlainRect，其确定位置用

矩形的左上角坐标来标识，包含：

添加两个属性：矩形左上角坐标startX和startY。

两个构造方法：

带4个参数的构造方法，用于对startX、startY、width和height属性初始化；

不带参数的构造方法，将矩形初始化为左上角坐标、长和宽都为0的矩形；

添加一个方法：

判断某个点是否在矩形内部的方法isInside(double x,double y)。如在矩形内，返回true, 否则，返回false。

 提示：点在矩形类是指满足条件：x>=startX&&x<=(startX+width)&&y&lt;startY&&y>=(startY-height)

（3）编写PlainRect类的测试程序创建一个左上角坐标为（10，10），长为20，宽为10的矩形对象；计算并打印输出矩形的面积和周长；判断点(25.5，13)是否在矩形内，并打印输出相关信息。
</pre>
	<p>
		<%
			imgs("11", pageContext);
		%>
	</p>
</body>
</html>