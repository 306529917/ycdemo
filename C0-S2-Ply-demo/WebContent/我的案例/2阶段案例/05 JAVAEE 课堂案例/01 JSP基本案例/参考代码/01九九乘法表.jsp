<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>九九乘法表</title>
<style type="text/css">
span {
	display: inline-block;
	width: 80px
}
</style>
</head>
<body>
	<h3>九九乘法表：JSP脚本 + JSP表达式实现</h3>
	<%
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j <= i; j++) {
	%>
	<span><%=i%> * <%=j%> = <%=i * j%></span>
	<%
		}
	%>
	<br>
	<%
		}
	%>

	<h3>九九乘法表：JSP脚本实现</h3>
	<%
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j <= i; j++) {
				// out 对象用于在 JSP 脚本中输出html代码
				out.print("<span>" + i + " * " + j + "=" + (i * j) + "</span>");
	%>
	<%
		}
			out.print("<br>");
		}
	%>
</body>
</html>