package com.inhousedeveloper.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.inhousedeveloper.data.MenuModel;
import com.inhousedeveloper.services.MenuOfRestaurant;



/**
 * Servlet implementation class AddMenuItemToOrderServlet
 */

public class AddMenuItemToOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMenuItemToOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		out.print("Hello");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		ArrayList<MenuModel> cart = (ArrayList<MenuModel>) session.getAttribute("cart") ;  
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String menuId = request.getParameter("menu_id") ; 
	 	int menuid = Integer.parseInt(menuId) ;
		
		MenuModel menuMdl = MenuOfRestaurant.getMenuDetails(menuid) ;
		
		
		if (cart == null) {
			// First course being added by the user
			cart = new ArrayList<MenuModel>();
			session.setAttribute("cart", cart);
		}
		
		cart.add(menuMdl) ;
		
		System.out.println(cart.size());
		
		out.println("<html><head><title>Added food items</title>");
		out.println("<html lang='en'>");
		out.println("<head>");
		out.println("<title>Bootstrap Case</title>");
		out.println("<meta charset='utf-8'>");
		out.println("<meta name='viewport' content='width=device-width, initial-scale=1'>");
		out.println("<link rel='stylesheet' href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css'>");
		out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js'></script>");
		out.println("<script src='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js'></script>");
		out.println("<link rel='stylesheet' type='text/css' href='style.css'>");
		out.println("<style type='text/css'>");
		out.println("body{");
		out.println("background-color: lightblue;}");
		//out.println("background-image: url("food.jpg");");
		out.println("</style>");
       out.println("</head>");
       
   
  

		
		out.println("<body><h1>You added: " + menuMdl.getFoodItem() + "</h1>");
		
		out.println("<ul>");
		for (MenuModel menu : cart) 
		{
			String itemName = menu.getFoodItem() ;
			out.println("<li>");
			out.println("<b>" + itemName + "</b>" + "&nbsp;&nbsp;");
			out.println("</li>");
		}
		out.println("</ul>");
		
		
		out.println("<br><a href='restaurantdetails.jsp'>Add More Items</a>");
		out.println("<br /> <br />");
		
		
		
		
		out.println(" <form method='post' action='orders.html'>");
		out.println("<input type='hidden' name='courseId' value=''/>");
		out.println("<input type='submit' value='Place your order'/>");
		out.println("</form>");
		
		
		
		
		out.println("</body></html>");
		
		
	}

}
