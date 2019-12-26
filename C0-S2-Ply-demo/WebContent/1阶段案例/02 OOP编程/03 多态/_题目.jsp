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
定义类Human，具有若干属性和功能；定义其子类Man、Woman；在主类Test中分别创建子类、父类和上转型对象，并测试其特性。
	</pre>
	<p>
		<%
			imgs("01", pageContext);
		%>
	</p>

		<hr>
	<h3>题目02</h3>
	<pre>
编写一个Animal类，具有属性：种类；具有功能：吃、睡。定义其子类Fish和Dog，定义主类E，在其main方法中分别创建其对象并测试对象的特性。
	</pre>
	<p>
		<%
			imgs("02", pageContext);
		%>
	</p>
	
	
			<hr>
	<h3>题目03</h3>
	<pre>
(1)编写一个接口ShapePara，要求： 接口中的方法： int getArea()：获得图形的面积。int getCircumference()：获得图形的周长

(2)编写一个圆类Circle，要求：圆类Circle实现接口ShapePara。

该类包含有成员变量：

radius:public 修饰的double类型radius,表示圆的半径。

x：private修饰的double型变量x，表示圆心的横坐标。

y：protected修饰的double型变量y，表示圆心的纵坐标。

包含的方法有：

Circle(double radius) 有参构造方法。以形参表中的参数初始化半径，圆心为坐标原点。 double getRadius()：获取半径为方法的返回值。void setCenter(double x, double y)：利用形参表中的参数设置类Circle的圆心坐标。void setRadius(double radius)：利用形参表中的参数设置类Circle的radius域。
	</pre>
	<p>
		<%
			imgs("03", pageContext);
		%>
	</p>
	
	<hr>
	<h3>题目04</h3>
	<pre>
定义图形类Shape，该类中有获得面积的方法getArea()；定义长方形类Rect，该类是Shape的子类，类中有矩形长和宽的变量double a,double b，设置长和宽的方法setWidth()、setHeight(),使用getArea()求矩形面积
	</pre>
	<p>
		<%
			imgs("04", pageContext);
		%>
	</p>
	
	
		<hr>
	<h3>题目05</h3>
	<pre>
编写Java应用程序，定义Animal类，此类中有动物的属性：名称 name,腿的数量legs，统计动物的数量 count;方法：设置动物腿数量的方法 void setLegs(),获得腿数量的方法 getLegs(),设置动物名称的方法 setKind(),获得动物名称的方法 getKind(),获得动物数量的方法 getCount()。定义Fish类，是Animal类的子类，统计鱼的数量 count,获得鱼数量的方法 getCount()。定义Tiger类，是Animal类的子类，统计老虎的数量 count,获得老虎数量的方法 getCount()。定义SouthEastTiger类，是Tiger类的子类，统计老虎的数量 count,获得老虎数量的方法 getCount()。
	</pre>
	<p>
		<%
			imgs("05", pageContext);
		%>
	</p>
</body>
</html>