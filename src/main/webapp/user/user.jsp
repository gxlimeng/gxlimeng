<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add user</title>
</head>
<body>

	
	
	<h5>CURD  测试</h5>
	
	<a href="${pageContext.request.contextPath}/user/show"> return main </a>
	
	<br/>
	<form:form
		action="${pageContext.request.contextPath}/user/save"
		method="POST" modelAttribute="user"> 
		<c:if test="${user.type != 'NORMAL' }">
			<input type="hidden" name="_method" value="PUT" />
		</c:if> 
			国际化 <fmt:message key="user.userNo"/>=<form:input path="userNo" />
		<form:errors path="userNo"/>
		<br /> 
		userName=<form:input path="userName" />
		<form:errors path="userName"/>
		<br />
		userCode=<form:input path="userCode" />
		<form:errors path="userCode"/>
		<br />
		userPwd=<form:input path="userPwd" />
		<form:errors path="userPwd"/>
		<br />
		userEmail=<form:input path="userEmail" />
		<form:errors path="userEmail"/>
		<br />
		userTel=<form:input path="userTel" />
		<form:errors path="userTel"/>
		<br />
		commons=<form:input path="commons" />
		<form:errors path="commons"/>
		<br />
		<button type="submit" value="submit">submit</button>
	</form:form>
	
	<h5>JSON处理</h5>
	<a id="json"  href="${pageContext.request.contextPath}/user/json">JSON 处理</a>
	
	<!-- Spring mvc 处理静态资源 -->
	<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
	<script src="../jquery/jquery-2.2.1.min.js" type="text/javascript"></script>
	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="../bootstrap/js/bootstrap.js" type="text/javascript"></script>

	<script type="text/javascript">
		$(function() {
			$("#json").click(function() {
				var url = this.href;
				var args = {};
				$.post(url, args, function(data) { 
					for (var i = 0; i < data.length; i++) {
						alert(data[i].userName);
					}
				});
				return false;
			});
		});
	</script>
</body>
</html>