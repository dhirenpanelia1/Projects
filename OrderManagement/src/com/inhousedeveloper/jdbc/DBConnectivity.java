package com.inhousedeveloper.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnectivity 
{
	private static String dbSourceUrl = "jdbc:mysql://localhost/OrderManagement";
	static private Connection courseDbConn;
	static private String userId = "root";
	static private String dbPassword = "";
	
	public static Connection getConnection() throws SQLException 
	{
		if (courseDbConn == null) 
		{
			courseDbConn =  DriverManager.getConnection(dbSourceUrl, userId, dbPassword);
		}
	
		return courseDbConn ;
	}
	
	public static void shutdown() throws SQLException {
		if (courseDbConn != null) {
			courseDbConn.close();
		}
	}
	
	public static void main(String[] args)
	{
		try {
			getConnection() ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
