package com.itheima.a_cookie.b_last_visit;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LastVisitServlet
 */
public class LastVisitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0.设置编码
		response.setContentType("text/html;charset=utf-8");
		PrintWriter writer = response.getWriter();
		
		//1.获取指定名称的cookie
		Cookie cookie =getCookieByName("lastTime",request.getCookies());
		
		if(cookie == null) {
			writer.println("You are visiting the first time");
		} else {
			//get the time in previous cookie
			String value = cookie.getValue();
			Long time = Long.parseLong(value);
			Date date = new Date(time);
			writer.println("Last time you visited at: " + date.toLocaleString());
		}
		//update the date in cookie using current time
		Date d = new Date();
		cookie = new Cookie("lastTime", new Date().getTime() + "");
		//set max expiration as 1 hour
		cookie.setMaxAge(3600);
		cookie.setPath(request.getContextPath()+ "/");
		response.addCookie(cookie);
	}
	
	private Cookie getCookieByName(String name, Cookie[] cookies) {
		if(cookies!=null){
			for (Cookie c : cookies) {
				//通过名称获取
				if(name.equals(c.getName())){
					//返回
					return c;
				}
			}
		}
		return null;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
