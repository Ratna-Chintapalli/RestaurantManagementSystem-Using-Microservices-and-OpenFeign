package com.vcube.orderservice.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.vcube.orderservice.response.FoodItems;
import com.vcube.orderservice.response.Restaurant;

@FeignClient(name="restaurantservice" ,url="http://localhost:9797")
public interface RestaurantClient {
	@GetMapping("api/r1/getRestaurant/{id}")
	Restaurant getRestaurant(@PathVariable("id") Long id);
	@GetMapping("api/r1/getAllFoodItems/{id}/foods")
	List<FoodItems> getFoods(@PathVariable("id") Long id);

}
