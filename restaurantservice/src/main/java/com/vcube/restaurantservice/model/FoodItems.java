package com.vcube.restaurantservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="fooditems")
public class FoodItems {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer id;
	String name;
	double price;

	@ManyToOne
	@JoinColumn(name="restaurant_id",referencedColumnName="id")
	private Restaurant restaurant;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	public FoodItems(Integer id, String name, double price, Restaurant restaurant) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.restaurant = restaurant;
	}
	public FoodItems() {
	}
	
}
