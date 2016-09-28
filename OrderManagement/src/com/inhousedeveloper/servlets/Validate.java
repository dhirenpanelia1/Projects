package com.inhousedeveloper.servlets;

import java.sql.*;

import com.inhousedeveloper.jdbc.DBConnectivity;

public class Validate
 {
     public static boolean checkUserLogin(String email,String pass) 
     {
    	 boolean status = false;
      
    	 try
    	 {
    		 Connection connection = DBConnectivity.getConnection();
    		 
    		 PreparedStatement prepstatement = connection.prepareStatement("select * from user where email_id = ? and password = ?");
    		 prepstatement.setString(1, email);
    		 prepstatement.setString(2, pass);
         
    		 ResultSet result = prepstatement.executeQuery();
    		 status = result.next();
        
    		 // ps.close();
        	 // connection.close();
    	 } 
    	 catch(Exception e) 
    	 {
    		 e.printStackTrace();
    	 }
    	 
         return status ;                 
     }
     
     public static boolean registerUser(String email, String password, String name) 
     {
    	 boolean success = false;
    	 
    	 try 
    	 {
    		 Connection connection = DBConnectivity.getConnection();
    		 
    		 PreparedStatement prepstatement = connection.prepareStatement("INSERT INTO user (name, email_id, password) VALUES (?, ?, ?)");
    		 prepstatement.setString(1, name);
    		 prepstatement.setString(2, email);
    		 prepstatement.setString(3, password);
    		 
    		 int rowsAffected = prepstatement.executeUpdate();
    		 
    		 if (rowsAffected > 0) 
    		 {
    			 success = true;
    		 }
    		 
    		 // ps.close();
             //connection.close();
    		 
    	 } 
    	 catch (SQLException sql) 
    	 {
    		 sql.printStackTrace();
    	 }
    	 
    	 return success;
     }
}