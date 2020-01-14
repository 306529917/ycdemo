<%@page import="java.util.*"%>
<%@page import="com.yc.jee.util.DBHelper"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>图书列表</title>
</head>
<body>
	<h1>图书列表</h1>
	<%
		String sql = "select * from books";
		List<Map<String, Object>> list = DBHelper.selectList(sql);
	%>
	<table style="width: 100%">
		<tr style="background-color: #ccc">
			<td>ID</td>
			<td>书名</td>
			<td>出版社</td>
			<td>出版时间</td>
			<td>作者</td>
			<td>数量</td>
		</tr>
		<%
			for (Map<String, Object> m : list) {
		%>
		<tr>
			<td><%=m.get("bookid")%></td>
			<td>
				<!-- 注意：此处生成超链接，用于打开查看图书页面，地址?后面是请求参数的格式 -->
				<a href="bookShow.jsp?bookid=<%=m.get("bookid")%>">
					<%=m.get("bookname")%>
				</a>
			</td>
			<!-- 获取图书字段信息，生成表格展示  -->
			<td><%=m.get("bookpress")%></td>
			<td><%=m.get("pressdate")%></td>
			<td><%=m.get("bookauthor")%></td>
			<td><%=m.get("bookcount")%></td>
		</tr>
		<%
			}
		%>
	</table>
	<h3>功能说明</h3>
	<ol>
		<li>实现基本的图书信息的查询和查看
	</ol>
</body>
</html>