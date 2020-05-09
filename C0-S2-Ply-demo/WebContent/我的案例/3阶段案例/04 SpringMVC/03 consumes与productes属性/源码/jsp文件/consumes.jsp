<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
<script type="text/javascript">
	function post() {
		$.post("productes.do", null, function(data) {
			console.info(data);
			alert(data);
		});
	}

	function get() {
		$.get("productes.do", null, function(data) {
			console.info(data);
			alert(data);
		});
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
	<button onclick="get()">jQuery 发起 get 请求，访问 productes.do</button>
	<button onclick="post()">jQuery 发起 post 请求，访问 productes.do</button>
</body>
</html>