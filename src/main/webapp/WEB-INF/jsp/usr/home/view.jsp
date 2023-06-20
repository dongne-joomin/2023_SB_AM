<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이미지 뷰</title>
</head>
<body>
	<c:forEach var="file" items="${files }">
		<div>
   			<h2>${file.title}</h2>
 			<a href=""><img src="/usr/home/file/${file.id}" width="80" height="80"/></a>
 			<h2>${file.price}</h2>
		</div>
	</c:forEach>
</body>
</html>