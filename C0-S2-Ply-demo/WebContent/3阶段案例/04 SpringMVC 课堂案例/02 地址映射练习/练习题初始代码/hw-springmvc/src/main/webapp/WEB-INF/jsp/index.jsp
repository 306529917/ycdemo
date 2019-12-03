<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SpringMVC练习题</title>
</head>
<body>
	<fieldset>
		<legend>请求地址映射练习一</legend>
		要求：请定义控制器方法实现页面跳转，方法内只能写一个 return 语句返回页面
		<ul>
			<li><a href="toTaobao">打开淘宝（taobao.jsp）</a>
			<li><a href="toBaidu">打开百度（baidu.jsp）</a>
			<li><a href="taobao/page">打开淘宝（taobao.jsp）</a>
			<li><a href="baidu/page">打开百度（baidu.jsp）</a>
		</ul>
		<ul>
			<li><a href="Taobao">打开淘宝（taobao.jsp）</a>
			<li><a href="javaTaobao">打开淘宝（taobao.jsp）</a>
			<li><a href="jsTaobao">打开淘宝（taobao.jsp）</a>
			<li><a href="mysqlTaobao">打开淘宝（taobao.jsp）</a>
			<li><a href="xmlTaobao">打开淘宝（taobao.jsp）</a>
		</ul>
		<ul>
			<li><a href="page/taobao">打开淘宝（taobao.jsp）</a>
			<li><a href="page/a/taobao">打开淘宝（taobao.jsp）</a>
			<li><a href="page/a/b/taobao">打开淘宝（taobao.jsp）</a>
			<li><a href="page/a/b/c/taobao">打开淘宝（taobao.jsp）</a>
		</ul>
		<ul>
			<li><a href="toPage?flag">打开淘宝（taobao.jsp）</a>
			<li><a href="toPage?flag=1">打开淘宝（taobao.jsp）</a>
			<li><a href="toPage?flag=2">打开淘宝（taobao.jsp）</a>
			<li><a href="toPage?type=1">打开淘宝（taobao.jsp）</a>
			<li><a href="toPage?type=2">打开百度（taobao.jsp）</a>
			<li><a href="toPage?type=3">打开百度（baidu.jsp）</a>
			<li><a href="toPage?type=4">打开百度（baidu.jsp）</a>
		</ul>
		<div style="text-align: center;"><a href="index?order=1">下一关</a></div>
	</fieldset>
</body>
</html>