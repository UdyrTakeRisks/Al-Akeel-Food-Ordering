package com.redhat.project.rest;

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
import javax.ws.rs.core.MediaType;

import java.util.List;

import com.redhat.project.data.MealRepository;
import com.redhat.project.data.OrderRepository;
import com.redhat.project.data.RestaurantRepository;
import com.redhat.project.data.UserRepository;
import com.redhat.project.model.Order;
import com.redhat.project.model.Restaurant;
import com.redhat.project.model.User;


@Path("/")
@Stateless
@RolesAllowed("Customer")
public class CustomerRESTService {
	
	@Inject
	OrderRepository orderRepo;
	
	@Inject
	RestaurantRepository restaurantRepo;
	
	@Inject
	UserRepository userRepo;
	
	@Inject
	MealRepository mealRepo;
	
	User user = new User();
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("createOrder/{Id}")
	public Order createOrder(Order order, @PathParam("Id") int Id) {
		
		userRepo.saveUser(user);   
		user = userRepo.findUserById(Id); 
		
		if(user.getRole() == "Customer" /*&& order.getRestaurant().getId() == Id*/) {
			Restaurant res = restaurantRepo.findById(Id);
			mealRepo.saveMeals(res);
			orderRepo.saveOrder(order,res); 
		}
 
		return order;
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("listOrders/{id}") 
	public List<Order> listOrders(@PathParam("id") int id) {
		user = userRepo.findUserById(id);
		if(user.getRole() == "Customer" && user.getId() == id)
			return orderRepo.listAllOrdersForCustomer(id); // !!!!
		
		return orderRepo.listAllOrdersForCustomer(id);  
		
	}
	
	
	@PUT 
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("editOrder")
	public void editOrder(Order order) {
		
		orderRepo.editOrder(order);  
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("listRestaurants") 
	public List<Restaurant> listAllRestaurants() {
		return restaurantRepo.getAllRestaurants();
	}
	 
}
