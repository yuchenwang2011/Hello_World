package com.itheima.web.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.domain.User;
import com.itheima.service.UserService;

public class LoginServlet extends HttpServlet {
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
			throw new RuntimeException("网络异常,请稍后再试!");
		}
		
		//3.判断user是否为空
		if(user==null){
			//3.1若为空 写"用户名和密码不匹配"
			response.getWriter().print("用户名和密码不匹配,3秒之后跳转");
		}else{
			response.getWriter().print(user.getUsername()+":欢迎回来");
		}
	}
}
