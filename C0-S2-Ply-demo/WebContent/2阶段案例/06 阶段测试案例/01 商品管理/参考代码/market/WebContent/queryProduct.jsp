<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>商品查询</title>
</head>
<body>
	<h3>商品查询</h3>
	<form action="query.s">
		<button>查询</button>
		<button formaction="editProduct.jsp">新增</button>
	</form>
	<table border="1px" style="width: 100%">
		<tr>
			<th>ID</th>
			<th>名称</th>
			<th>价格</th>
			<th>库存</th>
			<th>进价</th>
			<th>类型</th>
			<th>描述</th>
			<th>图片</th>
			<th>操作</th>
		</tr>
		<% 
			List<Map<?,?>> list = (List<Map<?,?>>)request.getAttribute("list");
			if(list==null){
		%>
			<tr><td colspan="10">没有查询到商品记录</td></tr>
		<%} else { 
			for(Map<?,?> row : list){
				pageContext.setAttribute("r", row);
		%>
		<tr>
			<td>${r.pid}</td>
			<td>${r.pname}</td>
			<td>${r.pprice}</td>
			<td>${r.cost}</td>
			<td>${r.inprice}</td>
			<td>${r.ptype}</td>
			<td>${r.pdesc}</td>
			<td><img alt="" src="${r.pimg}" height="30px"></td>
			<td><a href="edit.s?pid=${r.pid}">修改</a></td>
		</tr>
		<%} } %>
	</table>


</body>
</html>