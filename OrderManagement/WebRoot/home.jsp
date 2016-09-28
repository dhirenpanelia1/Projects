<%@page import="com.inhousedeveloper.services.RestaurantsList"%>
<%@page import="com.inhousedeveloper.data.RestaurantModel"%>
<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
  </head>
  
  <body>
    Restaurant List <br>
    
    
    <%
    
    RestaurantsList rsist = new RestaurantsList() ;
    
    ArrayList<RestaurantModel> resList = rsist.getRestaurantList() ;
    
    
    for (RestaurantModel res : resList)
    {	
    	%> <ul>
    		<li>
    		
    		<form method='post' action='restaurantdetails.jsp'>
    		<input type='hidden' name='res_id' value='<%= res.getId() %>' />
    		<input type='submit' value='<%= res.getName() %>'/>
    		  
    		</form>
    		
    		</li>
    	</ul>	
    	
    	<%
    }
   
    
    
    
   %>
		
    
  </body>
</html>
