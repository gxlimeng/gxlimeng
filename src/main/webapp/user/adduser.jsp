<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add user</title>
</head>
<body>

	<form:form
		action="${pageContext.request.contextPath}/user/saveUser"
		method="POST" modelAttribute="user">

		<c:if test="${user.userName != null }">
			<input type="hidden" name="_method" value="PUT" />
		</c:if> 
			userNo=<form:input path="userNo" />
		<br /> 
		userName=<form:input path="userName" />
		<br />
		userCode=<form:input path="userCode" />
		<br />
		userPwd=<form:input path="userPwd" />
		<br />
		userEmail=<form:input path="userEmail" />
		<br />
		userTel=<form:input path="userTel" />
		<br />
		commons=<form:input path="commons" />
		<br />
		<button type="submit" value="submit">submit</button>
	</form:form>
</body>
</html>