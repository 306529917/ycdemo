<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>功能需求</h3>
	<ol>
		<li>查询商品
		<li>添加商品信息（不含图片上传）
		<li>修改商品信息
		<li>编辑商品必须使用管理员用户登录
	</ol>
	<h3>设计要求</h3>
	<ol>
		<li>在Oracle/Mysql中创建数据库、表结构，并输入测试数据
		<li>使用 Servlet + JSP 实现业务功能
	</ol>
	<h3>语言和环境</h3>
	<ol>
		<li>语言： java语言、Jsp+Servlet、Html、JavaScript
		<li>环境： Oracle/Mysql
		<li>工具： Eclipse
	</ol>
	<h3>时间要求</h3>
	<ol>
		<li>笔试：30分钟
		<li>机试：2小时30分钟
	</ol>
	<h3>相关文件下载</h3>
	<ol>
		<li><a href="<%=application.getContextPath() %>/dj.do?file=mysql-connector-java-5.1.47.jar" download="mysql-connector-java-5.1.47.jar">mysql-connector-java-5.1.47.jar</a>
		<li><a href="$image.zip" download="图片包.zip">图片包.zip（image目录）</a>
		<li><a href="market.sql" download="market.sql">market.sql（如果是考试不会提供）</a>
	</ol>
</body>
</html>