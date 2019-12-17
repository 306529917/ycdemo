<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>案例演示</title>
<style type="text/css">
li {
	margin: 5px
}
</style>
</head>
<body>
	<h3>案例演示</h3>
	<ul>
		<%
			String dir = "参考代码";
			String realPath = new File(application.getRealPath(request.getServletPath())).getParent() + "/" + dir;
			System.out.println(realPath);
			for (File f : new File(realPath).listFiles()) {
		%>
		<li><a href="<%=dir%>/<%=f.getName()%>"><%=f.getName()%></a> <%
 	}
 %>
	</ul>
</body>
</html>