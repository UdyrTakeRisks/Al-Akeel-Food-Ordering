package com.redhat.project.rest;

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

import com.redhat.project.data.OrderRepository;
import com.redhat.project.data.RestaurantRepository;
import com.redhat.project.model.Order;
import com.redhat.project.model.Restaurant;


@Path("/")
@Stateless
//@RolesAllowed("Customer")
public class CustomerRESTService {
	
	@Inject
	OrderRepository orderRepo;
	
	@Inject
	RestaurantRepository restaurantRepo;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/createOrder")
	public void createOrder() {
		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/listOrders/{id}") 
	public List<Order> listAllOrders(@PathParam("id") int id) {
		return orderRepo.listAllOrdersForCustomer(id); // !!!!
	}
	
	
	@PUT 
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("editOrder")
	public void editOrder() {
		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/listRestaurants") 
	public List<Restaurant> listAllRestaurants() {
		return restaurantRepo.getAllRestaurants();
	}
	 
}
