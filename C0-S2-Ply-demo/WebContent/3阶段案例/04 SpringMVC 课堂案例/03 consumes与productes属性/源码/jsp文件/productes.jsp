<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
<script type="text/javascript">
	function json() {
		$.post("productes.do", null, function(data) {
			console.info(data);
			alert(data.msg);
		},"json");
	}

	function text() {
		$.get("productes.do", null, function(data) {
			console.info(data);
			alert(data);
		},"text");
	}
	
	function xml() {
		$.get("productes.do", null, function(data) {
			console.info(data);
			alert(data);
		},"xml");
	}
</script>
</head>
<body>
	<a href="productes.do">点击超链接发起 productes.do 请求</a>
	<hr>
	<form action="productes.do">
		<button>表单提交 get 类型的 productes.do 请求</button>
	</form>
	<hr>
	<form action="productes.do" method="post">
		<button>表单提交 post 类型的 productes.do 请求</button>
	</form>
	<hr>
	<form action="productes.do" method="post" enctype="multipart/form-data">
		<button>表单提交文件上传方式（enctype="multipart/form-data"）的 productes.do 请求</button>
	</form>
	<hr>
	<button onclick="json()">jQuery 发起返回类型为 json 的请求，访问 productes.do</button><br>
	<button onclick="text()">jQuery 发起返回类型为 text 的请求，访问 productes.do</button><br>
	<button onclick="xml()">jQuery 发起返回类型为 xml 的请求，访问 productes.do</button>
	<h3>注意</h3>
	<p>测试 RequestMapping 注解的 productes 属性，最好使用 AJAX 请求测试，因为只有AJAX请求才能修改HTTP请求头域值
</body>
</html>