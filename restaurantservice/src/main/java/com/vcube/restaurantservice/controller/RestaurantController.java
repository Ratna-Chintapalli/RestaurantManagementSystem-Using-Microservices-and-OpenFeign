package com.vcube.restaurantservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vcube.restaurantservice.model.FoodItems;
import com.vcube.restaurantservice.model.Restaurant;
import com.vcube.restaurantservice.service.RestaurantService;

@RestController
@RequestMapping("api/r1")
public class RestaurantController {
	@Autowired
	RestaurantService restaurantService;
	
	@GetMapping("/getAllRes")
	List<Restaurant> getAllRestaurants(){
		return restaurantService.getAllRestaurants();
	}
	@GetMapping("/getRestaurantById{id}")
	Restaurant getRestaurantById(@PathVariable Integer id) {
		return restaurantService.getRestaurant(id);
	}
	
	@GetMapping("/getFoodItems{id}")
	List<FoodItems> getAllFoodItemsRestaurantById(@PathVariable Integer id){
		return restaurantService.getAllFoodItems(id);
	}
	
	@PostMapping("addRes")
	ResponseEntity<Restaurant> addRestaurant(@RequestBody Restaurant restaurant) {
		Restaurant savedRestaurant=restaurantService.createRestaurantInfo(restaurant);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedRestaurant);
	}
	
	
	@PostMapping("addFood")
	ResponseEntity<FoodItems> addFoodItems(@RequestBody FoodItems foodItems) {
	    if (foodItems.getRestaurant() == null) {
	        throw new RuntimeException("Restaurant is required");
	    }
	    FoodItems savedFoodItems=restaurantService.createFoodItems(foodItems);
	    return ResponseEntity.status(HttpStatus.CREATED).body(savedFoodItems);
	}
	

}
