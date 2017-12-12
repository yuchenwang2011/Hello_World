package com.itheima.web.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.utils.CookieUtils;

/**
 * Servlet implementation class GetProductByIdServlet
 */
public class GetProductByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productId = request.getParameter("id");
		Cookie cookie = CookieUtils.getCookieByName("ids", request.getCookies());
		
		String ids = "";
		if(cookie == null) {
			ids = productId;
		} else {
			ids = cookie.getValue();
			List<String> asList = Arrays.asList(ids.split("-"));
		    LinkedList<String> list = new LinkedList<>(asList);
			if(list.contains(productId)) {
				list.remove(productId);
			} else {
				if(list.size() >= 3) {
					list.removeLast();
				} 
			}
			list.addFirst(productId);
			
			ids = "";
			for(String s : list) {
				ids = ids + s + "-";
			}
			ids = ids.substring(0, ids.length() - 1);
		}
		cookie = new Cookie("ids", ids);
		
		cookie.setPath(request.getContextPath() + "/");
		cookie.setMaxAge(3600);
		response.addCookie(cookie);
		
		response.sendRedirect(request.getContextPath() + "/product_info" + productId + ".htm");
	}	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
