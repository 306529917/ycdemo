<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录页面</title>
</head>
<body>
<h3>登录页面</h3>
<font color="red">${msg}</font>
<form action="login.s" method="post">
用户名：<input name="name"><br>
密码：<input name="pwd"><br>
<input type="submit" value="登录">
</form>


</body>
</html>