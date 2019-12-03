<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>商品编辑</title>
</head>
<body>

<form action="save.s" method="post">
<input name="pid" type="hidden" value="${row.pid}">
名称：<input name="pname" value="${row.pname}"><br>
价格：<input name="pprice" value="${row.pprice}"><br>
数量：<input name="cost" value="${row.cost}"><br>
进价：<input name="inprice" value="${row.inprice}"><br>
类型：<input name="ptype" value="${row.ptype}"><br>
描述：<input name="pdesc" value="${row.pdesc}"><br>
图片：<input name="pimg" value="${row.pimg}"><br>
<input type="submit" value="保存">
</form>


</body>
</html>