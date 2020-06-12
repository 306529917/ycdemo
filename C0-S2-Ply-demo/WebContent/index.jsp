<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>演示</title>
</head>
<body>
<%response.sendRedirect("http://"+request.getServerName()+":1112");%>
</body>
</html>