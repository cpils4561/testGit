<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
<h3>Login System</h3>
<form action="login.checkController" method="post">
   <p>
   UserName:<input type="text" name="userName"/><br/>
   Password:<input type="password" name="userPwd"/><br/>
   </p>
   <input type="submit" value="login"/>
</form>
</body>
</html>