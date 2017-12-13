package com.itheima.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Add2CartServlet
 */
public class Add2CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter writer = response.getWriter();
		String name = request.getParameter("name");
		
		@SuppressWarnings("unchecked")
		Map<String, Integer> cart = (Map<String, Integer>) request.getSession().getAttribute("cart");
		if(cart == null) {
			cart = new HashMap<String, Integer>();
			cart.put(name, 1);
			request.getSession().setAttribute("cart", cart);
		} else {
			if(cart.containsKey(name)) {
				cart.put(name, cart.get(name) + 1);
			} else {
				cart.put(name, 1);
			}
		}
		writer.println("item + <b>" + name + " </b> +  has been put to cart. <hr>");
		String continueShoppingUrl = request.getContextPath() + "/product_list.jsp";
		String shoppingCartUrl = request.getContextPath() + "/cart.jsp";
		writer.println("<a href="+ continueShoppingUrl + ">Continue Shopping</a> &nbsp;&nbsp;&nbsp;");
		writer.println("<a href="+ shoppingCartUrl + ">Go to shopping cart</a> &nbsp &nbsp &nbsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
