<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Members</title>
</head>
<body>
<h3> Welcome to 會員專區</h3>
<form:form action="addMembers" method="POST" modelAttribute="members">
<table>
<tr>
<td><form:label path="memberName">會員甲:</form:label> </td>
<td><form:input path="memberName"/></td>
</tr>
<tr>
<td><form:label path="gender">性別:</form:label> </td>
<td><form:input path="gender"/></td>
</tr>
<tr>
<td><form:label path="age">年齡:</form:label> </td>
<td><form:input path="age"/></td>
</tr>
<tr>
<td colspan="2"><form:button value="send">submit</form:button></td>
</tr>
</table>


</form:form>

</body>
</html>