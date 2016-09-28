package com.inhousedeveloper.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Signup
 */

public class SignupServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}*/

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		response.setContentType("text/html;charset=UTF-8");
    
		PrintWriter out = response.getWriter();
        
		String email = request.getParameter("email");
        String pass = request.getParameter("password");
        String name = request.getParameter("name");
        
       	if(Validate.registerUser(email, pass, name)) 
       	{
       		RequestDispatcher reqdispatch = request.getRequestDispatcher("home.jsp");
		    reqdispatch.forward(request, response);
		}
		else
		{
			out.println("<p style = \"color : red; \"> Oops! There was a problem during registration. Please try again. </p>");	
			RequestDispatcher reqdispatch = request.getRequestDispatcher("signup.jsp");
			reqdispatch.include(request, response);
		}
		
	}

}
