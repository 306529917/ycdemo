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
	<h3>题目06</h3>
	<pre>
定义类Human，具有若干属性和功能；定义其子类Man、Woman；在主类Test中分别创建子类、父类和上转型对象，并测试其特性。
	</pre>
	<p>
		<%
			imgs("06", pageContext);
		%>
	</p>

</body>
</html>