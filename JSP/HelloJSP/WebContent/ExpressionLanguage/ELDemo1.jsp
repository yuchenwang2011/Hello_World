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
		request.setAttribute("rKey", "rValue");
		session.setAttribute("sKey", "svalue");
		application.setAttribute("aKey", "aValue");
	%>
	
	Get request data: <br>
	Old method: <%=request.getAttribute("rKey") %> <br>
	EL method: ${requestScope.rKey} <br>
	<hr>
	Get Session data: <br>
	Old method: <%=session.getAttribute("sKey") %> <br>
	EL method: ${sessionScope.sKey} <br>
	<hr>
	Get application data: <br>
	Old method: <%=application.getAttribute("aKey") %> <br>
	EL method: ${applicationScope.aKey} <br>
	
	<hr>
	EL even easier method: <br>
	EL method: ${aKey} <br>
</body>
</html>