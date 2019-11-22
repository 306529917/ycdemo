<%@page import="java.util.*"%>
<%@page import="com.yc.jee.util.DBHelper"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html style="width: 100%">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>图书信息</title>
<style type="text/css">
label {
	width: 100px;
	display: inline-block;
	text-align: left;
}

input[name] {
	width: 200px;
	text-align: center;
}

input:not([name]) {
	width: 100px
}

form, h1 {
	line-height: 30px;
	text-align: center;
}

.btn_input {
	width:150px;
	text-align: center;
	margin: 10px
}
</style>
</head>
<body>
	<h1>图书信息编辑</h1>
	<%
		String bookid = request.getParameter("bookid");
		if(bookid!=null){
			String sql = "select * from books where bookid=?";
			Map<String, Object> m = DBHelper.selectOne(sql, bookid);
			// 将查出的图书数据（map集合），放入页面上下文对象属性中，可以使用 EL表达式（${...}） 输出图书信息
			pageContext.setAttribute("book", m);
		}
	%>
	<form method="post" action="dosave.jsp">
		<input type="hidden" name="bookid" value="${param.bookid}">
		<label>书名:</label>
			<!-- 如果页面上下文中有 book 对象，则输出book的值，否则输出请求参数的值（表单回填） -->
			<input name="bookname" value="${empty book ? param.bookname : book.bookname}"><br>
		<label>出版社:</label>
			<input name="bookpress"	value="${empty book ? param.bookpress : book.bookpress}"><br>
		<label>出版时间:</label>
			<input name="pressdate"	value="${empty book ? param.pressdate : book.pressdate}" type="date"><br>
		<label>作者:</label>
			<input name="bookauthor" value="${empty book ? param.bookauthor : book.bookauthor}"><br>
		<label>数量:</label>
			<input name="bookcount"	value="${empty book ? param.bookcount : book.bookcount}" type="number"><br>
			
		<label class="btn_input"><input type="button" value="取 消" onclick="history.back()"></label>
		<label class="btn_input"><input type="submit" value="保 存"></label>
		
	</form>
</body>
</html>