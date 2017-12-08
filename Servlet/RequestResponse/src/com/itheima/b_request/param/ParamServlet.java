package com.itheima.b_request.param;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.tribes.util.Arrays;

/**
 * Servlet implementation class ParamServlet
 */
public class ParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Get a single parameter
		String username = request.getParameter("username");
		response.getWriter().println("Username is: " + username);
		
		//Get multiple parameters
		String[] hobbies = request.getParameterValues("hobby");
		response.getWriter().println("Hobbies are: " + Arrays.toString(hobbies));
		
		//Get all parameters
		response.getWriter().println("================all params====================");
		Map<String, String[]> paramMap = request.getParameterMap();
		for(String key : paramMap.keySet()) {
			response.getWriter().println(key + " : " + Arrays.toString(paramMap.get(key)) );
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
