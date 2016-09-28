package com.inhousedeveloper.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.inhousedeveloper.data.MenuModel;
import com.inhousedeveloper.jdbc.DBConnectivity;


public class MenuOfRestaurant {
	
	public static ArrayList<MenuModel> getMenuForRestaurant(int restaurantId) 
	{
		ArrayList<MenuModel> menuList = new ArrayList<>();
		
		try 
		{
			Connection connection = DBConnectivity.getConnection();
			
			PreparedStatement prepstatement = connection.prepareStatement("SELECT * FROM menu WHERE restaurant_id = ?");
			prepstatement.setInt(1, restaurantId);
		
			ResultSet result = prepstatement.executeQuery();
		
			while (result.next()) 
			{
				MenuModel menuEntry = new MenuModel();
			
				menuEntry.setId(result.getInt(1));
				menuEntry.setFoodItem(result.getString(2));
				menuEntry.setDescription(result.getString(3));
				menuEntry.setPice(result.getFloat(4));
				menuEntry.setRestaurantId(result.getInt(5));
				
				menuList.add(menuEntry);
			}
		
			// prepstatement.close();
			// connection.close();
		} 
		catch (SQLException sql) 
		{
			sql.printStackTrace();
		}
		
		return menuList ;
	}
	
	
	// Get Menu Object from Menu ID
	
			public static MenuModel getMenuDetails(int menuId)
			{
				MenuModel menumodel = new MenuModel() ;
				
				try 
				{
					Connection connection = DBConnectivity.getConnection();
					
					PreparedStatement prepstatement = connection.prepareStatement("SELECT * FROM menu WHERE id = ?");
					prepstatement.setInt(1, menuId);
					
					ResultSet result = prepstatement.executeQuery();
					
					
					while (result.next()) 
					{	
						menumodel.setId(result.getInt(1));
						menumodel.setFoodItem(result.getString(2));
						menumodel.setDescription(result.getString(3));
						menumodel.setPice(result.getFloat(4));
						menumodel.setRestaurantId(result.getInt(5));
					}
				
					//prepstatement .close();
		        	//connection.close();
				}
				catch (Exception e) 
				{
					e.printStackTrace();
				}
				
				
				return menumodel ;
			}
}
