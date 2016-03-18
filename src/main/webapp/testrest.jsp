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
<link rel="stylesheet"
	href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>

<body>
	<form action="testController/testUpate.do">
		userNo:<input type="text" name="userNo"  value="103108" /><br />
		userName:<input type="text" name="userName"  value="小李" /><br />
	 
		<input type="submit" name="submit" value="submit" />
	</form>


	<br />
	<br />
	<a href="testController/testSessionAttributes.do">testSessionAttributes</a>
	<br />

	<a href="testController/testMap.do">TestMap</a>
	<br />

	<a href="testController/testModelAndView.do">TestModelAndView</a>
	<br />

	<a href="testController/testSevletAPI.do">TestSevletAPI</a>
	<br />

	<br />
	<br />
	<form action="testController/testPojo.do">
		userNo:<input name="userNo" type="text" /> <br /> userName:<input
			name="userName" type="text" /><br /> userEmail:<input
			name="userEmail" type="email" /><br /> userPwd:<input
			name="userPwd" type="password" /> <br /> Address:<input
			name="address.add" type="text" /> <br /> <input type="submit"
			value="submit pojo" />
	</form>

	<br />
	<!-- REST TEST -->
	<!-- DELETE test -->
	<form method="post" action="testRestController/testRest/1.do">
		<input type="hidden" name="_method" value='PUT' /> <input
			type="submit" value="test rest PUT" />
	</form>
	<!-- DELETE test -->
	<form method="post" action="testRestController/testRest/2.do">
		<input type="hidden" name="_method" value='DELETE' /> <input
			type="submit" value="test rest DELETE" />
	</form>
	<!-- post test -->
	<form method="post" action="testRestController/testRest/3.do">
		<input type="submit" value="test rest post">
	</form>
	<a href="testRestController/testRest/4.do">test rest get</a>

	<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
	<script src="jquery/jquery-2.2.1.min.js" type="text/javascript"></script>
	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="bootstrap/js/bootstrap.js" type="text/javascript"></script>
	<script type="text/javascript">
		function click() {
			alert("33333");
		}
	</script>
</body>

</html>