<%@page import="com.yc.jee.util.IOUtils"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.io.File"%>
<%@page import="java.io.IOException"%>
<%@page import="com.yc.jee.util.WebHelper"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%!public void imgs(String prefix, PageContext pageContext) throws IOException {
		int ret = WebHelper.buildHtmlByFiles("<img src='$images/${name}'/><br>", "$images", prefix + "-.+", pageContext);
		if(ret==0){
			pageContext.getOut().println("没有案例截图");
		}
	}%>
<!DOCTYPE html>
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
		File dir = WebHelper.getRealFile("参考代码", request);
		File[] dirs = dir.listFiles();
		int index = 1;
		for (File d : dirs) {
			if (d.isFile())
				continue;
	%>
	<fieldset>
		<legend>
			<h3><%="题目" + index%></h3>
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
				String indexName = (index < 10 ? "0" : "") + index;
				imgs(indexName, pageContext);
				index ++;
			%>
		</p>
	</fieldset>
	<%
		}
	%>
</body>
</html>