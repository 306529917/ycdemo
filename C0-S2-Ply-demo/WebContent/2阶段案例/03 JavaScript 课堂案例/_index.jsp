<%@page import="java.util.Comparator"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>项目案例展示</title>
<style>
iframe {
	width: 400px;
	height: 300px;
	margin: 10px;
	border: 0px
}
fieldset{
	display: inline-block;
	margin: 10px
}
</style>
</head>
<body>
	<h3>案例演示</h3>
	<%
		String path = application.getRealPath(request.getServletPath());
		File file = new File(path);
		file = new File(file.getParent(), "参考代码");
		File[] files = file.listFiles();
		if (files == null) {
			out.println(file.getPath());
			return;
		}
		Arrays.sort(files, new Comparator<File>() {
			public int compare(File o1, File o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		for (File f : files) {
			if(f.isDirectory())continue;
	%>
	<fieldset>
		<legend>
			<a href="参考代码/<%=f.getName()%>"><%=f.getName()%></a>
		</legend>
		<iframe src="参考代码/<%=f.getName()%>"></iframe>
	</fieldset>
	<%
		}
	%>

</body>
</html>