<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>02 动态生成表单控件</title>
<style type="text/css">
span {
	display: inline-block;
	width: 120px
}
</style>
</head>
<body>
<h3>请选择你的爱好</h3>
<!-- 注意 form 的 action 属性，表单提交的页面还是当前页面，并且必须以 post 方式提交 -->
<form action="" method="post">
<!-- 表单中相同name的元素，在表单提交时会在服务器端构建成字符串数组，我们称之为数组型请求参数 -->
<span><input type="checkbox" name="like" value="篮球" checked="checked">篮球</span>
<span><input type="checkbox" name="like" value="电影" checked="checked">电影</span>
<span><input type="checkbox" name="like" value="手游" checked="checked">手游</span>
<span><input type="checkbox" name="like" value="看书" checked="checked">看书</span>
<span><input type="checkbox" name="like" value="排球">排球</span>
<span><input type="checkbox" name="like" value="滑板">滑板</span>
<span><input type="checkbox" name="like" value="瑜伽">瑜伽</span>
<span><input type="checkbox" name="like" value="乒乓球">乒乓球</span>
<span><input type="checkbox" name="like" value="围棋">围棋</span>
<span><input type="checkbox" name="like" value="书法">书法</span>
<p>根据勾选的选项动态生成指定的控件</p>
<input type="submit" value="生成下拉列表" formaction="?type=1">
<input type="submit" value="生成单选框" formaction="?type=2">
<input type="submit" value="生成文本框" formaction="?type=3">
<hr>
<p>扩展练习：请参考源代码实现动态生成多选框</p>
<input type="submit" value="生成多选框" formaction="?type=4">
<input type="submit" value="生成密码框" formaction="?type=5">

<%
	String type = request.getParameter("type");
	// 如果是通过表单中 submit 按钮跳转过来的，type 请求参数一定不为空
	if (type != null) {
	// request.getParameterValues 用于接收数组型参数
	String[] likes = request.getParameterValues("like");
		
%>
	<hr>
	<% if("1".equals(type)){ %>
		<h3>动态生成下拉列表</h3>
		<select style="width: 150px">
		<%for(String like : likes ) {%>
			<option><%=like %></option>
		<%} %>
		</select>
	<%} %>
	
	<% if("2".equals(type)){ %>
		<h3>动态生成多选框</h3>
		<%for(String like : likes ) {%>
			<span><input value="<%=like%>" type="checkbox"><%=like %></span>
		<%} %>
	<%} %>
	
	<% if("3".equals(type)){ %>
		<h3>动态生成文本框</h3>
		<%for(String like : likes ) {%>
			<span><input value="<%=like%>" style="width:100px"></span>
		<%} %>
	<%} %>
<%} %>
</form>
</body>
</html>