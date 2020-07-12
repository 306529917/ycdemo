<!DOCTYPE html>
<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.io.FileFilter"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.io.File"%>
<%@page import="java.io.IOException"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="com.yc.jee.util.WebHelper"%>
<%@page import="com.yc.jee.util.IOUtils"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%!
	private static final String QUESTION_DIR = "解题参考";
	public void imgs(File dir, PageContext pageContext) throws IOException {
		String path = QUESTION_DIR + "/" + dir.getName() + "/截图";
		String html = "<fieldset class='imgf'>\n"
				+ "	<legend>${name}</legend>\n"
				+ " <a href='" + path + "/${name}' class='MagicZoom'>\n"
				+ " <img src='" + path + "/${name}'/></a>\n"
				+ " </fieldset>";
		int ret = WebHelper.buildHtmlByFiles(html, path, ".+\\.(png|gif|jpg|bmp)", pageContext);
		if (ret == 0) {
			pageContext.getOut().println("没有案例截图");
		}
	}
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/demo/_css/magiczoomplus.css" rel="stylesheet" type="text/css" media="screen"/>
<script src="/demo/_js/magiczoomplus.js"></script>
<style type="text/css">
h3 {
	margin: 0px auto
}

.imgf {
	display: inline-block;
	vertical-align: top;
	max-width: 200px;
}

</style>
<script type="text/javascript">
function copy(id) {
    var Url2=document.getElementById(id).innerText;
    var oInput = document.createElement('input');
    oInput.value = Url2;
    document.body.appendChild(oInput);
    oInput.select(); // 选择对象
    document.execCommand("Copy"); // 执行浏览器复制命令
    oInput.className = 'oInput';
    oInput.style.display='none';
}
</script>
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
		int index = 0;
		for (File d : dirs) {
			String name = "";
			if(d.getName().matches("^.+[:：].+")){
				name = "：" + d.getName().replaceAll("^.+[:：]", "");
			}
			
			String zipa = "";
			File srcDir = new File(d,"初始代码");
			if(srcDir.exists()){
				File rootDir = new File(application.getRealPath("/"));
				String path = srcDir.getPath().replace(rootDir.getPath(), "");
				path = path.replaceAll("\\\\", "/");
				zipa += " <a href='http://"+request.getServerName()+":1112/zip.do?file=" + path + "'>点击下载题目初始代码</a>";
			}
	%>
	<fieldset>
		<legend>
			<h3>题目 <%=++index%><%=name%><span style="font-size: 0.7em"><%=zipa%></span>
			<button onclick='copy("p<%=index%>")'>复制题目</button>
			</h3>
		</legend>
		<div id="p<%=index%>">
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
		</div>
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