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

	<a href="${pageContext.request.contextPath}/trest/users">Back Index</a>
	<h5>表单</h5>	
	<form:form action="${pageContext.request.contextPath}/trest/user" method="POST" modelAttribute="user"> 
		<form:errors path="*"/>
		<form:hidden path="_method"/>
		<!-- 
		type=${user.type}AA
		<c:if test="${user.type != '' && user.type != null }">
			<input type="hidden" name="_method" value="PUT" />
		</c:if> 
		 -->
			国际化 =<form:input path="no" />
		 
		<br /> 
		userName=<form:input path="userName" />
		<br /> 
		_method=<form:input path="_method"  readonly="true" />
		 
		<br />
		userCode=<form:input path="userCode" />
		 
		<br />
		userPwd=<form:input path="userPwd" />
		<form:errors path="userPwd"/>
		<br />
		userEmail=<form:input path="userEmail" />
		 
		<br />
		userTel=<form:input path="userTel" />
		<form:errors path="userTel"/>
		<br />
		commons=<form:input path="commons" />
		
		<br />
		<button type="submit" value="submit">submit</button>
	</form:form>
	 
</body>
</html>