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
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.redhat.project.data.RestaurantRepository;
import com.redhat.project.model.Restaurant;


@Stateless
//@RolesAllowed("RestaurantOwner")
@Path("/") 
public class RestaurantRESTService {
	
	@Inject
	private RestaurantRepository restaurantRepo;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("createMenu")
	public void createRestaurantMenu() {
		
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("editMenu")
	public void editRestaurantMenu() {
		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getDetails/{Id}")
	public Restaurant getRestaurantDetails(@PathParam("Id") int Id) {
		Restaurant restaurant = restaurantRepo.findById(Id);
		if(restaurant == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
		return restaurant; 
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("createReport/{Id}")
	public void createRestaurantReport() {
		
	}
	
	
	
}
