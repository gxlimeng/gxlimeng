<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>REST Operation</title>
</head> 
<body>
	<h4>REST 类型请求测试 GET/POST/PUT/DELETE</h4> 
	
	<h5 align="center">USERS LIST  CURD  测试 </h5>
	<h5>
		<a href="${pageContext.request.contextPath}/test/index.jsp">Back Index</a>
		<br/>
		<a href="${pageContext.request.contextPath}/trest/cuser">Add User</a>
	</h5>
	<form action="${pageContext.request.contextPath}/trest/rest" method="post">
		Search : <input type="text" name="no" />
		<button type="submit">Search</button>
	</form>
	<table>
		<tr>
			<th>No</th>
			<th>userCode</th>
			<th>userName</th>
			<th>userPwd</th>
			<th>userEmail</th>
			<th>userTel</th>
			<th>userStatus</th>
			<th>commons</th>
			<th />
			<th />
		</tr>
		<c:forEach items="${ requestScope.users }" var="user">
			<tr>
				<td>${user.no }</td>
				<td>${user.userCode }</td>
				<td>${user.userName }</td>
				<td>${user.userEmail }</td>
				<td>${user.userPwd }</td>
				<td>${user.userTel }</td>
				<td>${user.userStatus }</td>
				<td>${user.commons }</td>
				<td><a href="${pageContext.request.contextPath}/trest/uuser/${user.no}">Edit</a></td>
				<td><a class="delete" href="${pageContext.request.contextPath}/trest/duser/${user.no}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	
	<!-- delete 有post请求转换为delete请求使用  -->
	<form id="delete" action="null" method="post">
		<input type="hidden" name="_method" value="DELETE" />
	</form>
	
	<!-- Spring mvc 处理静态资源 -->
	<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
	<script src="../jquery/jquery-2.2.1.min.js" type="text/javascript"></script>
	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="../bootstrap/js/bootstrap.js" type="text/javascript"></script>
	<script src="../js/ajaxfileupload.js" type="text/javascript"></script>

	<script type="text/javascript">
		$(function() {
			$(".delete").click(function() {
				var href = $(this).attr("href");
				$("#delete").attr("action", href).submit();
				return false;
			});
		})
	</script>
</body>
</html>