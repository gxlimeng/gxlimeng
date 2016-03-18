<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html lang="zh_CN">

	<head>
		<!--确保适当的绘制和触屏缩放，需要在 <head> 之中添加 viewport 元数据标签-->
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>LOGIN</title>
		<!-- 新 Bootstrap 核心 CSS 文件 -->
		<link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css"> 
	</head>

	<body> 
		<form method="post"  action="loginController/test.do"> 
			<input type="email" id="map.inputEmail" name="map.inputEmail" placeholder="Email address" > 
			<input type="password" id="map.inputPassword"  name="map.inputPassword" placeholder="Password" >
			<button  id="signin" class="btn btn-lg btn-primary btn-block" type="submit" onclick="click()">Sign in</button>
		</form> 

		<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
		<script src="jquery/jquery-2.2.1.min.js" type="text/javascript"></script>
		<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
		<script src="bootstrap/js/bootstrap.js" type="text/javascript"></script>
		<script type="text/javascript"  >
			function click(){
				alert("33333");
			}
		</script>
	</body>

</html>