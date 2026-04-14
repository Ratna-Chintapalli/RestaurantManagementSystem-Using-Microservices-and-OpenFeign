package com.vcube.orderservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="order")
public class Order {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Long restaurantId;
	private Long foodItemsId;
	private String customerName;
	public Order(Long id, Long restaurantId, Long foodItemsId, String customerName) {
		super();
		this.id = id;
		this.restaurantId = restaurantId;
		this.foodItemsId = foodItemsId;
		this.customerName = customerName;
	}
	public Order() {
		super();
	}
	

}
