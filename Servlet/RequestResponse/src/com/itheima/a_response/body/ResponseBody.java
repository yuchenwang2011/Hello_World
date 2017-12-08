package com.itheima.a_response.body;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResponseBody extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.setContentType("text/html;charset=utf-8");
		response.setHeader("content-type", "text/html;charset=utf-8");
		
		PrintWriter writer = response.getWriter();
		writer.println("<table border='1'><tr>");
		writer.println("<td>Username</td>");
		writer.println("<td>Tom</td></tr>");
		
		
		writer.println("<tr><td>password</td>");
		writer.println("<td>Tom</td></tr>");
		writer.println("</tr></table>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
