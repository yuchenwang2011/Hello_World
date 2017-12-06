package com.itheima.a_response.location;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LocationServlet
 */
public class LocationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("The page will be directed to /location2, by using code 302");
		//Method1: 302 is used for redirect pages
		//"location" is the header key of the key-value pair
		//response.setStatus(302);
		//response.setHeader("location", "/RequestResponse/location2");
		
		//method2
		response.sendRedirect("/RequestResponse/location2");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
