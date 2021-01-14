<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="<c:url value="/css/login.css"/>">
</head>
<body>
<div class="container">
<form method="post" action="login.controller">
 <h2>Login</h2>
 			
            <input type="text" name="userName"  placeholder="Username" class="name" autocomplete="off" />
            <input type="password" name="password" placeholder="Password" class="pass" />
            <input type="submit" id="btn-submit" value="submit"/>
            <span id="warning">${err.msg}${err.userName}<br>${err.password}</span>
</form>
</div>

</body>
</html>