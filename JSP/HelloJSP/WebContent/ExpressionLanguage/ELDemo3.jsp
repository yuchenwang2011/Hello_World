<%@page import="com.itheima.domain.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		User u = new User();
		u.setId(1);
		u.setUsername("Mary");
		u.setPassword("123"); 
		
		request.setAttribute("user", u);
	%>
	<hr>
	Get data from a JavaBean: <br>
	Old Method: <%=((User)request.getAttribute("user")).getUsername() %><br>
	EL Method: ${user.username}<br>
	
</body>
</html>