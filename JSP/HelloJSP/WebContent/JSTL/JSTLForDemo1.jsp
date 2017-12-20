<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	This is equal to "for(int i = 1; i<=10; i++)" <br>
	<c:forEach begin="1" end="10" step="2" var="i" varStatus="vs">
		i value is: ${i} <br>
		vs count: ${vs.count} <br>
		vs current: ${vs.current} <br> 
		<hr>
	</c:forEach>
	
	
	<hr> Loop a list <br>
	<%
		List<String> list = new ArrayList<>();
		list.add("111");
		list.add("222");
		list.add("333");
		request.setAttribute("l", list);
	%>
	
	<c:forEach items="${l}" var = "n" varStatus="vs">
		 ${vs.current} th item of the list is: ${n} <br>
	</c:forEach>
</body>
</html>