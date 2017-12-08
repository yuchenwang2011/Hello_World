package com.itheima.b_request.header;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Some common methods for request object
 */
public class RequestHeaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//========================================================================
		//Below are how to get request start line
		String method = request.getMethod();
		response.getWriter().println("Method is: " + method);
		
		String uri = request.getRequestURI();
		response.getWriter().println("URI is : " + uri);
		
		StringBuffer url = request.getRequestURL();
		response.getWriter().println("URL is: " + url.toString());
		
		String query = request.getQueryString();
		response.getWriter().println("Query (parameters) is: " + query);
		
		String protocol = request.getProtocol();
		response.getWriter().println("Protocol is: " + protocol);
		
		String ipAddress = request.getRemoteAddr();
		response.getWriter().println("Remote IP address is: " + ipAddress);
		
		String path = request.getContextPath();
		response.getWriter().println("Path(project name) is: " + path);
		
		//=============================================================================
		//Below are how to get the request header
		String agent = request.getHeader("user-agent");
		response.getWriter().println("The core of the browser is: " + agent);
		
		String referer = request.getHeader("referer");
		if(referer == null) {
			response.getWriter().println("This is directly visited from browser");
		} else if (referer.contains("localhost")) {
			response.getWriter().println("This is directed from localhost");
		} else {
			response.getWriter().println("This is referered from : " + referer);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
