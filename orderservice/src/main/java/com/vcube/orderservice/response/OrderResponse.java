package com.vcube.orderservice.response;

public class OrderResponse {
	private String customerName;
	private Restaurant restaurant;
	private FoodItems foodItems;
	public OrderResponse(String customerName, Restaurant restaurant, FoodItems foodItems) {
		super();
		this.customerName = customerName;
		this.restaurant = restaurant;
		this.foodItems = foodItems;
	}
	public OrderResponse() {
		
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	public FoodItems getFoodItems() {
		return foodItems;
	}
	public void setFoodItems(FoodItems foodItems) {
		this.foodItems = foodItems;
	}
	
	

}
