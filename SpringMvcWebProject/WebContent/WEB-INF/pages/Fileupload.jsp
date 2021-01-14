<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>上傳破貓圖</title>
</head>
<body>
<form action="<c:url value="/fileuploadcontroller"/>" method="post" enctype="multipart/form-data">
給我上傳你的破貓圖:<br>
<input type="file" name="myfile" />
<input type="submit" name="upload"/>
</form>

</body>
</html>