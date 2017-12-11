package com.itheima.servlet.register;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.itheima.domain.User;
import com.itheima.service.UserService;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0.set encoding
		request.setCharacterEncoding("utf-8");
		//1. encapsulate data (use apache common beanutils for simplicity)
		User user = new User();
		try {
			BeanUtils.populate(user, request.getParameterMap());
			int result = new UserService().register(user);
			if(result == 1) {
				request.setAttribute("message", "success");
			} else {
				request.setAttribute("message", "failure");
			}
			request.getRequestDispatcher("/message").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		//2. Userservice.regist(user) , return int
		
		//3. check result and send to message servlet
		
		//4. 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
