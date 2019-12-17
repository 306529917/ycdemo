<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>案例演示</title>
</head>
<body>
	<h3>案例演示</h3>
	<ul>
	<%
		String dir = "参考代码";
		String path = request.getServletPath() + "/" + dir;
		String realPath = application.getRealPath(path);
		for (File f : new File(realPath).listFiles()) {
	%>
	<li><a href="<%=dir%>/<%=f.getName()%>"><%=f.getName()%></a>
	<%
		}
	%>
	</ul>
</body>
</html>