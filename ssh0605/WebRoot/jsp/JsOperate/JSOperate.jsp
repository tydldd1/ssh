<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<base href="<%=basePath%>">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>使用js实现增删改查</title>
		
		<script type="text/javascript" src="js/jQuery1.9.1-min.js"></script>
		<!-- jquery ui dialog使用的js -->
		<script src="js/jquery-ui/ui/jquery.ui.core.js"></script>
		<script src="js/jquery-ui/ui/jquery.ui.widget.js"></script>
		<script src="js/jquery-ui/ui/jquery.ui.mouse.js"></script>
		<script src="js/jquery-ui/ui/jquery.ui.draggable.js"></script>
		<script src="js/jquery-ui/ui/jquery.ui.position.js"></script>
		<script src="js/jquery-ui/ui/jquery.ui.resizable.js"></script>
		<script src="js/jquery-ui/ui/jquery.ui.button.js"></script>
		<script src="js/jquery-ui/ui/jquery.ui.dialog.js"></script>
		<script src="js/jquery-ui/ui/jquery.ui.effect.js"></script>
		<script src="js/jquery-ui/ui/jquery.ui.effect-blind.js"></script>
		<script src="js/jquery-ui/ui/jquery.ui.effect-explode.js"></script>
		
		<!-- jquery ui dialog使用的css -->
		<link rel="stylesheet" href="js/jquery-ui/themes/base/jquery.ui.all.css">
		
		<script type="text/javascript" src="js/JSOperate.js"></script>
	</head>
	
	<body>
		<div style="text-align: center;font: bold;color: green;">JS实现增删改保存操作</div><br>
		<div id="button">
			<input type="button" id="add" value="添加">
			<input type="button" id="update" value="修改">
			<input type="button" id="del" value="删除">
			<input type="button" id="save" value="保存">
		</div>
		
		<br>
		<div>*******以下为列表*******</div>
		<br>
		<div id="table">
			<table border="1px;">
				<!-- 标题 -->
				<thead>
					<tr>
						<td><input type="checkbox" id="checkAll"  onclick="checkAll()"/></td>
						<td>姓名</td>
						<td>年龄</td>
						<td>专业</td>
					</tr>
				</thead>
				
				<tbody id="content">
				
				</tbody>
				
			</table>
		</div>
		
		<!-- 弹出层 -->
		<div id="dialog">
			<div>
				<p>姓名：</p><input type="text" id="name"/>
			</div>
			<div>
				<p>年龄：</p><input type="text" id="age"/>
			</div>
			<div>
				<p>专业：</p><input type="text" id="major"/>
			</div>
		</div>
	</body>
</html>