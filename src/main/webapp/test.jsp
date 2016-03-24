<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>

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

	<!-- CURD 测试   -->
	<h4> CURD 测试  </h4>
	<a href="user/show">CURD 测试</a>

	<!-- MODEL ATTRIBUTE 测试   -->
	<h4> MODEL ATTRIBUTE 测试  </h4>
	<form action="testController/testModelAttributes.do" >
		userNo:<input type="text" name="userNo" value="103108" /><br />
		userName:<input type="text" name="userName" value="小李1" /><br /> 
		<input type="submit" name="submit" value="MODEL ATTRIBUTES REQUEST TEST " />
	</form>


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
	<!-- POJO对象传递 测试  -->
	<h4> POJO对象传递 测试</h4>
	<form action="testController/testPojo.do">
		userNo:		<input name="userNo" type="text" /> <br /> 
		userName: <input  name="userName" type="text" /><br /> 
		userEmail:  <input	name="userEmail" type="email" /><br /> 
		userPwd:	<input name="userPwd" type="password" /> <br /> 
		Address:	<input name="address.add" type="text" /> <br /> 
		<input type="submit" value="POJO-SUBMIT  - REQUEST TEST " />
	</form>

	<br />
	<!-- REST 类型请求测试 GET/POST/PUT/DELETE -->
	<h4>REST 类型请求测试 GET/POST/PUT/DELETE</h4>
	<!-- REST-PUT -->
	<form method="post" action="testRestController/testRest/1.do">
		<input type="hidden" name="_method" value='PUT' /> 
		<input type="submit" value="REST-PUT- REQUEST TEST " />
	</form>
	<!-- REST-DELETE -->
	<form method="post" action="testRestController/testRest/2.do">
		<input type="hidden" name="_method" value='DELETE' /> 
		<input type="submit" value="REST-DELETE - REQUEST TEST" />
	</form>
	<!-- REST-POST -->
	<form method="post" action="testRestController/testRest/3.do">
		<input type="submit" value="REST-POST - REQUEST TEST">
	</form>	
	<!-- REST-GET -->
	<a href="testRestController/testRest/4.do">REST-GET - REQUEST TEST</a>
	
	<br/>
	<!-- 表单请求测试 -->
	<h4>简单表单请求测试</h4>
	<form method="post" action="loginController/test.do">
		email:<input type="email"  name="map.inputEmail" > <br/>
		password:<input type="password" name="map.inputPassword" > <br/>
		<button id="signin"  type="submit" onclick="click()">Sign in</button>
	</form>


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