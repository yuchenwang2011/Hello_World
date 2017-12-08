package com.itheima.b_request.param;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Accept request parameters
 */
public class Param2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//this setCharacterEncoding method only works for post method
		request.setCharacterEncoding("UTF-8");
		String username  = request.getParameter("username");
		String password0 = request.getParameter("password");
		System.out.println("Username is: " + username);
		System.out.println("password not decoded: " + password0);
		//Below is a general method for both get and post methods
		String password = new String(request.getParameter("password").getBytes("iso8859-1"), "utf-8");
		System.out.println("password decoded : " + password);
	}

}
