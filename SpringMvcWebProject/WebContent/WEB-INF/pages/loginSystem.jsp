<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>來登入</title>
</head>
<body>
	<form action="<c:url value="/logincheck.controller"/>" method="post">
		<table>
			<tr>
				<td>username:</td>
				<td><input type="text" name="username"/></td>
				<td>${errors.name}</td>
			</tr>
			<tr>
				<td>userpassword:</td>
				<td><input type="password" name="userpwd"/></td>
				<td>${errors.pwd}</td>
			</tr>
			<tr>
				<td><input type="submit" name="send"></td>
				<td>${errors.msg}</td>
			</tr>
		</table>
	</form>

</body>
</html>