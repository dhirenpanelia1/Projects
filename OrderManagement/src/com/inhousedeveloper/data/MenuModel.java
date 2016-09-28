package com.inhousedeveloper.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.inhousedeveloper.jdbc.DBConnectivity;

public class MenuModel 
{
	private int id;
	private String foodItem;
	private String description;
	private float pice;
	private int restaurantId;

	
	// Getter Setter for ID
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	//
	
	public String getFoodItem() {
		return foodItem;
	}
	public void setFoodItem(String foodItem) {
		this.foodItem = foodItem;
	}
	
	
	//
	
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	//
	
	
	public float getPice() {
		return pice;
	}
	public void setPice(float pice) {
		this.pice = pice;
	}
	
	
	
	//
	
	
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	
}
