<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SpringMVC练习题</title>
<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
function toPage(){
	value = $("#num").val();
	if(value!="请选择"){
		if(value > 4){
			location.href="toPage?flag="+value;
		} else {
			location.href="toPage?type="+value;
		}
	} else {
		alert("请选择正确的编号");
	}
}

function call(type){
	$.post("call.do",{type:type},function(data){
		if(data=="taobao"){
			location.href = "toTaobao";
		} else {
			location.href = "toBaidu";
		}
	});
}

function call1(type){
	$.post("call1.do",{type:type},function(data){
		alert(data.msg);
		location.href = data.url;
	});
}

function exec(name){
	if(name=="跳转百度"){
		$.post("exec.do",null,function(data){
			alert(data.msg);
			location.href = data.url;
		});
	} else {
		$.get("exec.do",null,function(data){
			alert(data.msg);
			location.href = data.url;
		});
	}
}

</script>
</head>
<body>
	
	<fieldset>
		<legend>请求地址映射练习二</legend>
		要求：请查看页面源代码，根据程序逻辑进行操作
		<ul>
			<li>
			<form action="form.do">
				<input type="submit" value="跳转百度">
			</form>
			
			<li>
			<form action="form.do" method="post">
				<input type="submit" value="跳转淘宝">
			</form>
			
			<li>
			<form action="form.do">
				<input type="button" value="跳转百度" onclick="call(1)">
			</form>
			
			<li>
			<form action="form.do" method="post">
				<input type="button" value="跳转淘宝" onclick="call(2)">
			</form>
			
			<li>
			<form action="form.do">
				<input type="button" value="跳转百度" onclick="call1(1)">
			</form>
			
			<li>
			<form action="form.do" method="post">
				<input type="button" value="跳转淘宝" onclick="call1(2)">
			</form>

			<li>
				<input type="button" value="跳转百度" onclick="exec(this)">
			
			<li>
				<input type="button" value="跳转淘宝" onclick="exec(this)">

			<li>
				请选择正确的编号：<select id="num">
					<option>请选择</option>
					<c:forEach begin="1" end="10" step="1" var="i">
					<option value="${i}">${i}</option>
					</c:forEach>
				</select>
				<button onclick="toPage()">俺要看淘宝</button>
				<button onclick="toPage()">我要去百度</button>
				<font color="red">请自行验证跳转的页面是否正确！</font>
		</ul>
		<div style="text-align: center;"><a href="index?order=2">下一关</a></div>
	</fieldset>

</body>
</html>