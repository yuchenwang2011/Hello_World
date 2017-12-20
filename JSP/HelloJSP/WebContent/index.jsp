<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="/HelloJSP/hello">Cookie Hello World Example</a><br>
	<a href="/HelloJSP/jsp/page.jsp">JSP Hello World Example</a><br>
	<a href="/HelloJSP/jsp/exception.jsp">JSP Exception Example</a><br>
	<a href="/HelloJSP/jsp/include/include.jsp">JSP include Keyword</a><br>
	<a href="/HelloJSP/jsp/pageContext.jsp">JSP pageContext object</a><br>
	<a href="/HelloJSP/jsp/action/forward.jsp">JSP Action jsp:forward</a><br>
	<a href="/HelloJSP/jsp/action/actionInclude.jsp">JSP Action jsp:include</a><br>
	<hr>
	<a href="/HelloJSP/ExpressionLanguage/ELDemo1.jsp">Expression Language Demo 1:  Get Attribute for request/session/application</a><br>
	<a href="/HelloJSP/ExpressionLanguage/ELDemo2.jsp">Expression Language Demo 2:  Get Array/List/Map data</a><br>
	<a href="/HelloJSP/ExpressionLanguage/ELDemo3.jsp">Expression Language Demo 3:  Get Java Bean data</a><br>
	<a href="/HelloJSP/ExpressionLanguage/ELDemo4.jsp">Expression Language Demo 4:  Get Cookie Info</a><br>
	<a href="${pageContext.request.contextPath}/ExpressionLanguage/ELDemo4.jsp">Expression Language Demo 5:  pageContext object</a><br>
	<hr>
	<a href="${pageContext.request.contextPath}/JSTL/JSTLIf.jsp">JSTL: If expression</a><br>
	<a href="${pageContext.request.contextPath}/JSTL/JSTLForDemo1.jsp">JSTL: For expression demo 1</a><br>
</body>
</html>