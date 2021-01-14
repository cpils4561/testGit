<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
  #errMsg{color: red}
</style>
<title>Form</title>
</head>
<body>
	<form action="hello.controller" method="get">
		<table>
           <tr>
             <td>UserName</td>
             <td><input type="text" name="userName"/></td>
             <td id="errMsg">${errors.msg}</td>
           </tr>
           <tr>
             <td><input type="submit" value="Send"/></td>
           </tr>
		</table>
	</form>
</body>
</html>