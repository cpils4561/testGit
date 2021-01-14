<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
</head>
<body>


<%-- <h3>Success.${userName}</h3> --%>

<body>
<c:forEach var="picture"  items="${picture}" >
	圖片：${picture.id}<br>
	圖片名稱：${picture.filename}<br>
	<!--拼接圖片回顯的的URL-->
	<img  src="${selection}${picture.filename}"  height="200" width="200" ><br>
		<img  src="${selection}不知道為何.jpg"   height="200" width="200"><br>
</c:forEach>
</body>
</html>
