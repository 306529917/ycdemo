<%@page import="java.util.*"%>
<%@page import="com.yc.jee.util.DBHelper"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>图书列表</title>
<style type="text/css">
label{
	width: 100px;
	display: inline-block;
	text-align: center;
}
input[type="submit"]{
	width: 80px
}
th{
	line-height: 30px;
}
</style>
<script type="text/javascript">
function del(bookid){
	if(confirm("请确认要删除该图书吗?")){
		location.href='dodel.jsp?bookid=' + bookid;
	}
}
</script>
</head>
<body>
	<h1>图书列表</h1>
	<%
		String sql = "select * from books where 1=1";
		List<Object> params = new ArrayList<>();
		
		String bookname = request.getParameter("qbookname");
		String bookpress = request.getParameter("qbookpress");
		String bookauthor = request.getParameter("qbookauthor");
		
		if(bookname!=null && bookname.trim().isEmpty()==false){
			sql += " and bookname like ?";
			params.add("%"+bookname+"%");
		}
		
		if(bookpress!=null && bookpress.trim().isEmpty()==false){
			sql += " and bookpress like ?";
			params.add("%"+bookpress+"%");
		}
		
		if(bookauthor!=null && bookauthor.trim().isEmpty()==false){
			sql += " and bookauthor like ?";
			params.add("%"+bookauthor+"%");
		}
		
		List<Map<String, Object>> list = DBHelper.selectList(sql,params.toArray());
	%>
	<form method="post" style="margin: 10px">
		<label>书名:</label><input name="qbookname" value="${param.qbookname}">
		<label>出版社:</label><input name="qbookpress" value="${param.qbookpress}">
		<label>作者:</label><input name="qbookauthor" value="${param.qbookauthor}">
		<label><input type="submit" value="查 询"></label>
		<label><input type="submit" value="添 加" formaction="bookEdit.jsp"></label>
	</form>
	<table style="width: 100%; border: 1px solid #888">
		<tr style="background-color: #ccc">
			<th>ID</th>
			<th>书名</th>
			<th>出版社</th>
			<th>出版时间</th>
			<th>作者</th>
			<th>数量</th>
			<th>图片</th>
			<th width="200px">操作</th>
		</tr>
		<%
			for (Map<String, Object> m : list) {
		%>
		<tr>
			<td><%=m.get("bookid")%></td>
			<td>
				<a href="bookShow.jsp?bookid=<%=m.get("bookid")%>">
					<%=m.get("bookname")%>
				</a>
			</td>
			<td><%=m.get("bookpress")%></td>
			<td><%=m.get("pressdate")%></td>
			<td><%=m.get("bookauthor")%></td>
			<td><%=m.get("bookcount")%></td>
			<td align="center"><img src="../资料/<%=m.get("bookimage")%>" height="80px"></td>
			<td align="center">
				<input type="submit" value="修 改" onclick="location.href='bookEdit.jsp?bookid=<%=m.get("bookid")%>'">
				<input type="submit" value="删 除" onclick="del(<%=m.get("bookid")%>)">
			</td>
		</tr>
		<%
			}
		%>
	</table>
	<h3>功能说明</h3>
	<ol>
		<li>实现基本的图书信息的增删改查
		<li>实现了组合条件查询
	</ol>
	
</body>
</html>