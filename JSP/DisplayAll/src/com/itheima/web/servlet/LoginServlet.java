package com.itheima.web.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.domain.User;
import com.itheima.service.UserService;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String requestCapcha = request.getParameter("capcha");
		String sessionCapcha = (String) request.getSession().getAttribute("capcha");
		//make sure the capcha will be used only once
		request.getSession().removeAttribute("capcha");
		
		if(requestCapcha == null || requestCapcha.trim().length() == 0 || sessionCapcha == null) {
			 request.setAttribute("msg", "Please input a new capcha");
			 request.getRequestDispatcher("/login.jsp").forward(request, response);
			 return;
		}
		if(!requestCapcha.equalsIgnoreCase(sessionCapcha)) {
			 request.setAttribute("msg", "Capcha wrong");
			 request.getRequestDispatcher("/login.jsp").forward(request, response);
			 return;
		}
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User user = null;
		try {
			user = new UserService().getUserByUsernameAndPassword(username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(user == null) {
			 request.setAttribute("msg", "Username and password mismatch");
			 request.getRequestDispatcher("/login.jsp").forward(request, response);
			 return;
		} else {
			if("ok".equals(request.getParameter("savename"))) {
				Cookie cookie = new Cookie("savename", username);
				cookie.setPath(request.getContextPath() + "/");
				cookie.setMaxAge(60 * 60);
				response.addCookie(cookie);
			}
			request.getSession().setAttribute("user", user);
		}
		response.sendRedirect(request.getContextPath() + "/index.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
