<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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
		//array
		request.setAttribute("array", new String[]{"aa","bb","cc"});
	
		//list
		List<String> list = new ArrayList<String>();
		list.add("aaa");
		list.add("bbb");
		request.setAttribute("list", list);
		
		//map
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "Tom");
		map.put("gender","male");
		request.setAttribute("m", map);
		
		//special character
		request.setAttribute("special.name", "Jerry");
	%>
	
	<hr>
	Get data from array: <br>
	Old Method: <%=((String[])request.getAttribute("array"))[0] %><br>
	EL Method: ${array[0]} <br>

	<hr>
	Get data from list: <br>
	Old Method: <%=((List<String>)request.getAttribute("list")).get(1) %> <br>
	EL Method: ${list[1]} <br>
	El Method, list size is : ${list.size()} <br>
	
	<hr>
	Get data from map: <br>
	Old Method: <%=((Map<String,String>)request.getAttribute("m")).get("name") %><br>
	EL Method: ${m.gender} <br>	
	
	<hr>
	Get data for special character <br>
	${requestScope["special.name"]} <br>
</body>
</html>