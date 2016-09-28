<%@page import="com.inhousedeveloper.services.RestaurantsList"%>
<%@page import="com.inhousedeveloper.services.MenuOfRestaurant"%>
<%@page import="com.inhousedeveloper.data.MenuModel"%>
<%@page import="com.sun.glass.ui.Menu"%>
<%@page import="com.inhousedeveloper.data.RestaurantModel"%>
<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    <title>User Login Page</title>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
 <body>
 
 <% 
 
 	HttpSession sessionvar = request.getSession() ;
 	Integer resid = (Integer) sessionvar.getAttribute("res_id") ;
 
 	if(resid == null)
 	{
		 resid = Integer.parseInt(request.getParameter("res_id")) ;
		 sessionvar.setAttribute("res_id", resid) ;
 	}
 
 	RestaurantModel resmodel = RestaurantsList.getRestaurantDetails(resid) ;
 	
 	//
 	String resName = resmodel.getName() ;
 	String resDescription = resmodel.getDescription() ;
 	String resAddress = resmodel.getRestaurantAddress() ;
 	
 	ArrayList<MenuModel> menuList = MenuOfRestaurant.getMenuForRestaurant(resid) ;
 	
 	
 %>

    

    
    <h1> <%= resName %></h1> 
    <h4> <%= resAddress %></h4> 
    <h5> <%= resDescription %></h5>
    
    <hr>
    
    Menu List :
    <br /><br />
    
    <% 
    for (MenuModel menuItem : menuList)
    {	
    	int id = menuItem.getId() ;
    	String foodItemName = menuItem.getFoodItem() ;
    	String foodItemDescription = menuItem.getDescription() ;
    	float price = menuItem.getPice() ;
    	
    
    %>
    
    <table border="1" style="width:100%">
    <tr>
    <td> <%= id %> </td> 
    <td> <%= foodItemName %></td> 
    <td> <%= foodItemDescription %></td> 
    <td> <%= price %></td> 
 	<td>
    <form method='post' action='addMenutItemToOrder.html'>
   		<input type='hidden' name='menu_id' value='<%= id %>' />
  		<input type='submit' value='Add to order'/>
    </form>
    </td>
    </tr>
    
    </table>
   <%
   	
    }
    
    
    
	
    
   %>
   
   
   
    
    
  </body>
</html>
