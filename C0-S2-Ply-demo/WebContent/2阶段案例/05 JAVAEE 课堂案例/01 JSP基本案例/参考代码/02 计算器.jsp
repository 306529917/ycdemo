<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>02 计算器</title>
<style type="text/css">
input[type=button], input[type=submit] {
	width: 100%
}
</style>
<script type="text/javascript">
	function put(obj) {
		switch (obj.value) {
		case '%':
		case '+':
		case '-':
		case '*':
		case '/':
			// 重新设置数值，解决数字中已经输入了加减乘除号的问题
			num.value = parseFloat(num.value);
			break;
		case '.':
			// 已经输入了 . 号就忽略本次输入
			if (num.value.indexOf(".") > 0) {
				return;
			}
		}
		num.value += obj.value;
	}
	function clean() {
		num.value = '';
	}
	function back() {
		if (num.value.length > 0) {
			num.value = num.value.substring(0, num.value.length - 1);
		}
	}
</script>
</head>
<body>
	<%
		double result = 0;
		String num = request.getParameter("num");
		if (num != null) {
			String[] nums = num.split("[-/\\+\\*]");
			String op = num.replaceAll("[\\d\\.]", "");
			if (nums.length == 2 && op.length() == 1) {
				float f1 = Float.parseFloat(nums[0]);
				float f2 = Float.parseFloat(nums[1]);
				switch (op) {
				case "%":
					result = f1 % f2;
					break;
				case "*":
					result = f1 * f2;
					break;
				case "/":
					result = f1 / f2;
					break;
				case "+":
					result = f1 + f2;
					break;
				case "-":
					result = f1 - f2;
					break;
				}
			}
		}
		// 数字格式化对象
		DecimalFormat nf = new DecimalFormat("###,###,###.############");
		// 数字 0 不显示
		String strValue = result == 0 ? "" : nf.format(result);
	%>

	<form action="" method="post">
		<table>
			<tr>
				<td colspan="4"><input id="num" name="num"
					value="<%=strValue%>" style="text-align: right;"></td>
			</tr>
			<tr>
				<td><input type="button" value="C" onclick="clean()"></td>
				<td><input type="button" value="&lt;" onclick="back()"></td>
				<td><input type="button" value="%" onclick="put(this)"></td>
				<td><input type="button" value="/" onclick="put(this)"></td>
			</tr>
			<tr>
				<td><input type="button" value="1" onclick="put(this)"></td>
				<td><input type="button" value="2" onclick="put(this)"></td>
				<td><input type="button" value="3" onclick="put(this)"></td>
				<td><input type="button" value="*" onclick="put(this)"></td>
			</tr>
			<tr>
				<td><input type="button" value="4" onclick="put(this)"></td>
				<td><input type="button" value="5" onclick="put(this)"></td>
				<td><input type="button" value="6" onclick="put(this)"></td>
				<td><input type="button" value="-" onclick="put(this)"></td>
			</tr>
			<tr>
				<td><input type="button" value="7" onclick="put(this)"></td>
				<td><input type="button" value="8" onclick="put(this)"></td>
				<td><input type="button" value="9" onclick="put(this)"></td>
				<td><input type="button" value="+" onclick="put(this)"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="button" value="0"
					onclick="put(this)"></td>
				<td><input type="button" value="." onclick="put(this)"></td>
				<td><input type="submit" value="=" name="op"></td>
			</tr>
		</table>
	</form>
</body>
</html>