<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	Using pageContext object to set attribute for other object, this feature is not used frequently
	<hr>
<%
	pageContext.setAttribute("rKey", "request value put by pageContext", pageContext.REQUEST_SCOPE);
%>

<%=request.getAttribute("rKey")
%>

<hr>
Easier way to find attribute in all of Application > session > request > pageContext field from small to big <br>
<%=pageContext.findAttribute("rKey") %>


</body>
</html>