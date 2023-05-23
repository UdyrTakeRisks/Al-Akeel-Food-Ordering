package com.redhat.project.rest;

import java.util.Set;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.redhat.project.data.MealRepository;
import com.redhat.project.data.RestaurantRepository;
import com.redhat.project.model.Meal;
import com.redhat.project.model.Restaurant;


@Stateless
@RolesAllowed("RestaurantOwner")
@Path("/") 
public class RestaurantRESTService {
	
	@Inject
	private RestaurantRepository restaurantRepo;
	
	@Inject
	private MealRepository mealRepo;
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("createMenu")
	public String createRestaurantMenu(Restaurant restaurant) {
		
        mealRepo.saveMeals(restaurant);
 		restaurantRepo.saveRestaurant(restaurant); 
		return "Sent Successfully"; 
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON) 
	@JsonDeserialize
	@Path("editMenu/{Id}")
<<<<<<< HEAD
	public Set<Meal> editRestaurantMenu(Restaurant newRes, @PathParam("Id") int Id) {
		Restaurant restaurant = restaurantRepo.findById(Id);
		if(restaurant.getId() == Id) {
			mealRepo.editMeals(newRes);
			newRes.setMeals(restaurant.getMeals()); 
		} 
		return newRes.getMeals();     
=======
	public Set<Meal> editRestaurantMenu(Set<Meal> meals, @PathParam("Id") int Id) {
		Restaurant restaurant = restaurantRepo.findById(Id);
		if(restaurant.getId() == Id) {
			mealRepo.editMeals(meals, restaurant);   
		}
		return restaurant.getMeals();   
>>>>>>> 87dd8f157f51ddb945a282a89d3eb60d943ab842
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getDetails/{Id}")
	public Restaurant getRestaurantDetails(@PathParam("Id") int id) {
		Restaurant restaurant = restaurantRepo.findById(id);
		if(restaurant == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
		return restaurant;  
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("createReport/{Id}")
	public void createRestaurantReport(@PathParam("Id") int Id) {
//		Restaurant restaurant = restaurantRepo.findById(Id);
//		Order order;
//		double SumOfAllOrders = 0.0;
//		int NumOfCompletedOrders = 0 , NumOfCanceledOrders = 0;
//		//if(order.getOrderStatus() == "delivered") {
//			//SumOfAllOrders += restaurant.getOrders();
//		//} 
	}
	
	
	
}
