package com.itheima.web.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.domain.User;
import com.itheima.service.UserService;

public class LoginServlet extends HttpServlet {
	 @Override
	public void init() throws ServletException {
		ServletContext servletContext = this.getServletContext();
		servletContext.setAttribute("LoginCount", 0);
		System.out.println("The init() method needs to be loaded on startup to enable the counter");
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0.设置编码
		response.setContentType("text/html;charset=utf-8");
		
		//1.接受用户名和密码
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		//2.调用userservice 里的login(username,password) 返回值:User user
		User user = null;
		try {
			user = new UserService().login(username,password);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Network Exception, please try later!");
		}
		
		//3.判断user是否为空
		if(user==null){
			//若为空 写"用户名和密码不匹配"
			response.getWriter().print("username and password mismatch, will redirect after 3 seconds");
			response.addHeader("refresh", "3;url=/LoginExample/login.htm");
		}else{
			response.getWriter().print(user.getUsername()+" : welcome back");
			ServletContext servletContext = this.getServletContext();
			//User integer here to avoid the case null, int can't be assigned to null but Integer can be.
			Integer count = (Integer) servletContext.getAttribute("LoginCount");
			count++;
			servletContext.setAttribute("LoginCount", count);
		}
	}
}
