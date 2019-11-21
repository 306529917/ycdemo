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
<script type="text/javascript">
function createXmlHttp() {
	var xmlhttp;
	try {
		xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");
	} catch (e) {
		//console.log(e.message);
		try {
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		} catch (e) {
			//console.info(e);
			try {
				xmlhttp = new XMLHttpRequest();
			} catch (e) {
				console.log(e);
				alert("您的服务器不支持AJAX!");
			}
		}
	}
	return xmlhttp;
}

function post(url, data, func){
	var xmlhttp = createXmlHttp();
	xmlhttp.onreadystatechange = function(){
		if (xmlhttp.readyState == 4) {
			if (xmlhttp.status == 200) {
				func(xmlhttp.responseText);
			}
		}
	};
	xmlhttp.open("post", url, true);
	xmlhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	//xmlhttp.setRequestHeader('Content-Type', 'multipart/form-data;charset=utf-8');
	xmlhttp.send(data);
}

function checkName(name){
	if(name){
		post("checkName.s","name="+name,function(data){
			if(data){
				alert(data);
			}
		});
	}
}
function uploadImage() {
	// 创建 Ajax 文件上传对象, 使用表单 id 作为参数
	var fd = new FormData(ff);
	post("uploadImage.s", fd, function(data){
		bookimage.src = data;
	});
}
</script>
</head>
<body>
	<h1>图书信息编辑</h1>
	<%
		String bookid = request.getParameter("bookid");
		String bookimage = "选择书籍图片.jpg";
		if(bookid!=null){
			String sql = "select * from books where bookid=?";
			Map<String, Object> m = DBHelper.selectOne(sql, bookid);
			pageContext.setAttribute("book", m);
			// 设置缺省图片
			if(m.get("bookimage") != null){
				bookimage = (String)m.get("bookimage");
			}
		}
	%>
	<form method="post" action="uploadImage.s" enctype="multipart/form-data" id="ff">
	
		<input type="file" name="file" id="file" style="display: none;" onchange="uploadImage()">
		<img id="bookimage" src="images/<%=bookimage%>" height="200px" onclick="file.click()"><br>
		
		<input type="hidden" name="bookid" value="${param.bookid}">
		<label>书名:</label>
			<input name="bookname" value="${empty book ? param.bookname : book.bookname}"
					<%if(bookid==null){ // 使用 JSP 脚本动态添加 onblur 事件%>
						onblur="checkName(this.value)"
					<%}%>
				><br>
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