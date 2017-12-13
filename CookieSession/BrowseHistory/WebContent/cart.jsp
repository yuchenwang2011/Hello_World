<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" align="center" width="20%">
		<tr>
			<td>Name</td>
			<td>Number</td>
		</tr>
		<%
			Map<String, Integer> cart = (Map<String, Integer>) session.getAttribute("cart");
			if(cart == null){
		%>
			<tr>
				<td colspan="2">Your cart is still empty</td>
			</tr>
		<%
			} else {
				for(String name: cart.keySet()){
					out.print("<tr>");
					out.print("<td>");
					out.print(name);
					out.print("</td>");
					
					out.print("<td>");
					out.print(cart.get(name));
					out.print("</td>"); 
					out.print("</tr>");
				}
			}
		%>
	</table>
	<hr>
	<center><a href="/BrowseHistory/product_list.jsp">Continue Shopping</a>&nbsp;&nbsp;&nbsp; </center>
</body>
</html>