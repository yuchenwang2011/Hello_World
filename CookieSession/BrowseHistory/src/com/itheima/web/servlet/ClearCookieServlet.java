package com.itheima.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.utils.CookieUtils;

/**
 * Servlet implementation class ClearCookieServlet
 */
public class ClearCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie cookie = CookieUtils.getCookieByName("ids", request.getCookies());
		if(cookie != null) {
			Cookie cookie2 = new Cookie("ids", "");
			cookie2.setPath(request.getContextPath() + "/");
			cookie2.setMaxAge(0);
			response.addCookie(cookie2);
		}
		response.sendRedirect(request.getContextPath() + "/product_list.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
