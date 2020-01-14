<!DOCTYPE html>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.io.FileFilter"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
h3 {
	margin: 0px auto
}

.imgf {
	display: inline-block;
	vertical-align: top;
}
</style>
</head>
<body>
	<%
		File dir = WebHelper.getRealFile(QUESTION_DIR, request);
		// 获取所有目录（题目）
		File[] dirs = dir.listFiles(new FileFilter() {
			int index = 1;
			public boolean accept(File f) {
				/**
					对题目目录重新命名，必须在本机调试才可以使用
					注意：要刷新多次，才能整理完目錄
				*/
				if (f.isDirectory()) {
					if ("127.0.0.1".equals(request.getLocalAddr())) {
						IOUtils.rename(f, "题目", index++, 2);
					}
					return true;
				} else {
					return false;
				}
			}
		});
		Arrays.sort(dirs);
		for (File d : dirs) {
	%>
	<fieldset>
		<legend>
			<h3><%=d.getName()%></h3>
		</legend>
		<p>
			<%
				File desc = new File(d, "题目.html");
					if (desc.exists()) {
						FileInputStream fis = null;
						InputStreamReader isr = null;
						BufferedReader br = null;
						try {
							fis = new FileInputStream(desc);
							isr = new InputStreamReader(fis, "UTF-8");
							br = new BufferedReader(isr);
							String line;
							while ((line = br.readLine()) != null) {
								out.println(line);
							}
						} finally {
							IOUtils.close(br);
						}
					}
			%>
		</p>
		<p>
			<%
				imgs(d, pageContext);
			%>
		</p>
	</fieldset>
	<%
		}
	%>
</body>
</html>

<%@page import="com.yc.util.IOUtils"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.io.File"%>
<%@page import="java.io.IOException"%>
<%@page import="com.yc.jee.util.WebHelper"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%!private static final String QUESTION_DIR = "解题参考";

	public void imgs(File dir, PageContext pageContext) throws IOException {
		String path = QUESTION_DIR + "/" + dir.getName() + "/截图";
		String html = "<fieldset class='imgf'>\n" + "	<legend>${name}</legend>\n" + "	<img src='" + path
				+ "/${name}'>\n" + "</fieldset>";
		int ret = WebHelper.buildHtmlByFiles(html, path, ".+\\.(png|gif|jpg|bmp)", pageContext);
		if (ret == 0) {
			pageContext.getOut().println("没有案例截图");
		}
	}%>