package com.inhousedeveloper.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.inhousedeveloper.data.RestaurantModel;
import com.inhousedeveloper.jdbc.DBConnectivity;

public class RestaurantsList 
{
	public ArrayList<RestaurantModel> getRestaurantList() 
	{
		ArrayList<RestaurantModel> restaurantsList = new ArrayList<>();
		
		try 
		{
			Connection connection = DBConnectivity.getConnection();

			PreparedStatement prepstatement = connection.prepareStatement("SELECT * FROM restaurant");
		
			ResultSet result = prepstatement.executeQuery();
		
			while (result.next()) 
			{
				RestaurantModel resmodel = new RestaurantModel();
				
				resmodel.setId(result.getInt(1));
				resmodel.setName(result.getString(2));
				resmodel.setDescription(result.getString(4));
				resmodel.setMenu(result.getString(5));
			
				restaurantsList.add(resmodel);
			}
		
			//prepstatement .close();
        	//connection.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return restaurantsList ;
	}
	
	
	// Get Restaurant Object from Restaurant ID
	
		public static RestaurantModel getRestaurantDetails(int resId)
		{
			RestaurantModel resmodel = new RestaurantModel() ;
			
			try 
			{
				Connection connection = DBConnectivity.getConnection();
				
				PreparedStatement prepstatement = connection.prepareStatement("SELECT * FROM restaurant WHERE id = ?");
				prepstatement.setInt(1, resId);
				
				ResultSet result = prepstatement.executeQuery();
				
				System.out.println(result.toString());
			
				while (result.next()) 
				{	
					resmodel.setId(result.getInt(1));
					resmodel.setName(result.getString(2));
					resmodel.setDescription(result.getString(4));
					resmodel.setMenu(result.getString(5));
					resmodel.setRestaurantAddress(result.getString(6));
				}
			
				//prepstatement .close();
	        	//connection.close();
			}
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			
			
			return resmodel ;
		}
}
