<%@page import="java.util.*"%>
<%@page import="com.yc.jee.util.DBHelper"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>图书信息</title>
<style type="text/css">
span {
	display: inline-block;
	width: 100px
}
</style>
</head>
<body>
	<h1>图书信息</h1>
	<%
		String sql = "select * from books where bookid=?";
		String bookid = request.getParameter("bookid");
		Map<String, Object> m = DBHelper.selectOne(sql, bookid);
	%>
	<ul>
		<li><span>ID：</span><%=m.get("bookid")%></li>
		<li><span>书名：</span><%=m.get("bookname")%></li>
		<li><span>出版社：</span><%=m.get("bookpress")%></li>
		<li><span>出版时间：</span><%=m.get("pressdate")%></li>
		<li><span>作者：</span><%=m.get("bookauthor")%></li>
		<li><span>数量：</span><%=m.get("bookcount")%></li>
	</ul>
	<a href="#" onclick="history.back()" style="margin-left: 50px">返回</a>
</body>
</html>