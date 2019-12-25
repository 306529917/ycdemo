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
</body>
</html>