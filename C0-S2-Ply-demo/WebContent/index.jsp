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
function test(){
	try{
		var url = "https://github.com/306529917/ycdemo/blob/master/C0-S2-Ply-demo/WebContent/index.jsp";
		 $.ajax({
	            type: "get",
	            url: url, // 这个就是不同于当前域的一个URL地址，这里单纯演示，所以同域
	            dataType: "jsonp",
	            jsonp: "jsonpcallback",  // 指定回调函数，这里名字可以为其他任意你喜欢的，比如callback，不过必须与下一行的GET参数一致
	            data: "name=jxq&email=feichexia@yahoo.com.cn&jsonpcallback=?", // jsonpcallback与上面的jsonp值一致
	            success: function (json) {
	                alert(json);
	            }
	        });
	}catch(e){
		console.info(e)
	}
}
</script>
</head>
<body>
	<div class="easyui-layout" fit="true">
		<div data-options="region:'north'" style="height:50px"></div>
		<div data-options="region:'south',split:true" style="height:50px;"></div>
		<div data-options="region:'center'">
			<iframe src="test.s" width="100%" height="100%" style="border: 0px"></iframe>
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