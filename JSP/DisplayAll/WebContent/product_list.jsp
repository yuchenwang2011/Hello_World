<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" align="center">
		<tr>
			<td>ID</td>
			<td>Name</td>
			<td>Price</td>
			<td>Desc</td>
		</tr>
		<c:forEach items="${list}" var="p">
			<tr>
				<td>${p.id}</td>
				<td>${p.pname}</td>
				<td>${p.price}</td>
				<td>${p.pdesc}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>