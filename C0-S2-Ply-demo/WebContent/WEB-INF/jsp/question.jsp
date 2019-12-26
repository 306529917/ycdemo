<!DOCTYPE html>
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
</style>
</head>
<body>
	<%
		File dir = WebHelper.getRealFile(QUESTION_DIR, request);
		// 获取所有目录（题目）
		File[] dirs = dir.listFiles(new FileFilter() {
			public boolean accept(File f) {
				return f.isDirectory();
			}
		});
		Arrays.sort(dirs);
		// 对题目目录重新命名，必须在本机调试才可以使用
		if ("127.0.0.1".equals(request.getLocalAddr())) {
			for (int i = dirs.length; i > 0; i--) {
				String name = "题目" + (i < 10 ? "0" : "") + i;
				System.out.println(IOUtils.rename(dirs[i - 1], name));
			}
		}
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
						FileReader fr = null;
						BufferedReader br = null;
						try {
							fr = new FileReader(desc);
							br = new BufferedReader(fr);
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

<%@page import="com.yc.jee.util.IOUtils"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.io.File"%>
<%@page import="java.io.IOException"%>
<%@page import="com.yc.jee.util.WebHelper"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%!private static final String QUESTION_DIR = "参考代码";

	public void imgs(File dir, PageContext pageContext) throws IOException {
		String path = QUESTION_DIR + "/" + dir.getName() + "/截图";
		int ret = WebHelper.buildHtmlByFiles("<img src='" + path + "/${name}'/><br>", path, ".+\\.png", pageContext);
		if (ret == 0) {
			pageContext.getOut().println("没有案例截图");
		}
	}%>