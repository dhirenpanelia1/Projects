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

 <center>
    <div class="signup">
      <h1>Sign up to Web App</h1>
      <form method="post" action="userhome.html">
      	<p><input type="text" name="name" placeholder="Name"></p>
        <p><input type="text" name="email" placeholder="Email"></p>
        <p><input type="password" name="password" placeholder="Password"></p>
        <p><input type="submit" value="Sign up"></p>
      </form>
    </div>
</center>
    
  </body>
</html>
