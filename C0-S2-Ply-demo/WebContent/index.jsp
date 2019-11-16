<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>廖老师的案例站</title>
<link rel="stylesheet" type="text/css" href="http://${config.ychost}/helper/js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="http://${config.ychost}/helper/js/easyui/themes/icon.css">
<script type="text/javascript" src="http://${config.ychost}/helper/js/jquery.min.js"></script>
<script type="text/javascript" src="http://${config.ychost}/helper/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="http://${config.ychost}/helper/js/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
function openFile(node){
	node && node.attributes && node.attributes.href && open(node.attributes.href,"_blank");
}
</script>
</head>
<body>
	<div class="easyui-layout" fit="true">
		<div data-options="region:'north'" style="height:50px"></div>
		<div data-options="region:'south',split:true" style="height:50px;"></div>
		<div data-options="region:'center'">
		</div>
		<div class="easyui-tree" style="width:300px;" data-options="
				region:'west',
				iconCls:'icon-ok',
				url:'index.s?path=%2F案例',
				method:'post',
				animate:true,
				onClick:openFile,
				split:true">
		</div>
	</div>
</body>
</html>