package com.vcube.restaurantservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vcube.restaurantservice.model.FoodItems;
import com.vcube.restaurantservice.model.Restaurant;
import com.vcube.restaurantservice.repo.FoodItemsRepo;
import com.vcube.restaurantservice.repo.RestaurantRepo;

@Service
public class RestaurantService {
	@Autowired
	RestaurantRepo repo;
	
	@Autowired
	FoodItemsRepo foodItemsRepo;
	
	public Restaurant createRestaurantInfo(Restaurant restaurant) {
		return repo.save(restaurant);
	}
	public FoodItems createFoodItems(FoodItems foodItems) {

	    // 🔍 Get restaurant id from request
	    Integer restaurantId = foodItems.getRestaurant().getId();

	    // ✅ Fetch restaurant from DB
	    Restaurant restaurant = repo.findById(restaurantId)
	            .orElseThrow(() -> new RuntimeException("Restaurant not found with id: " + restaurantId));

	    // ✅ Set managed entity
	    foodItems.setRestaurant(restaurant);
	    FoodItems savedFoodItems=foodItemsRepo.save(foodItems);
	    // ✅ Save food item
	    return foodItemsRepo.save(savedFoodItems);
	}
	
	public List<Restaurant>  getAllRestaurants(){
	  return repo.findAll();
	}
	public Restaurant getRestaurant(Integer id){
		 return repo.findById(id).orElseThrow();
	}
	public List<FoodItems> getAllFoodItems(Integer id){
		return foodItemsRepo.findByRestaurantId(id);
	}
	
	
}
