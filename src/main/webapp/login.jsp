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
		<link rel="stylesheet" href="css/login.css" />
	</head>

	<body>
		<div class="container-fluid">
			<form class="form-signin" action="login/signin">
				<h2 class="form-signin-heading">Please sign in</h2>
				<label for="inputEmail" class="sr-only">Email address</label>
				<input type="email" id="inputEmail" name="inputEmail" class="form-control" placeholder="Email address" required autofocus>
				<label for="inputPassword" class="sr-only">Password</label>
				<input type="password" id="inputPassword"  name="inputPassword" class="form-control" placeholder="Password" required>
				<div class="checkbox">
					<label>
						<input type="checkbox" value="remember-me"> Remember me
					</label>
					<label>
						<a> Forget password</a>
					</label>
				</div>
				<button id="signin" class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
			</form>
		</div>

		<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
		<script src="jquery/jquery-2.2.1.min.js" type="text/javascript"></script>
		<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
		<script src="bootstrap/js/bootstrap.js" type="text/javascript"></script>
		<script type="text/javascript"  >
			$(function () {
				$("#signin").click(){
					$.ajax({
						url:"login/siginin",
						async:false,
						type:"post",
						success:function(rtnValue){
							if("wrongPwd" == rtnValue){
								alert("alert wrongPwd 1");
							}else if("wrongCode" == rtnValue){
								alert("alert wrongCode 2");
							}else{
								alert("alert success 3");
							}
						}
					});
				}
			}
		</script>
	</body>

</html>