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
import com.redhat.project.model.Order;
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
	public Set<Meal> editRestaurantMenu(Restaurant newRes, @PathParam("Id") int Id) {
		Restaurant restaurant = restaurantRepo.findById(Id);
		if(restaurant.getId() == Id) {
			mealRepo.editMeals(newRes);
			newRes.setMeals(restaurant.getMeals()); 
		} 
		return newRes.getMeals();     
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
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("createReport/{Id}")
	public int createRestaurantReport(@PathParam("Id") int Id) {
		
		Restaurant restaurant = restaurantRepo.findById(Id);
		int totalEarnings = 0;
		int numOfCompletedOrders = 0;
		int numOfCanceledOrders = 0;
		for (Order order : restaurant.getOrders()) {
			
			if (order.getOrderStatus().equals("delivered")) {
		        totalEarnings += order.getTotalPrice(); // Corrected method name
		        numOfCompletedOrders++;
		    } else if (order.getOrderStatus().equals("canceled")) {
		    	
		        numOfCanceledOrders++;
		      }
		}
		return totalEarnings; 
     }

	
}
