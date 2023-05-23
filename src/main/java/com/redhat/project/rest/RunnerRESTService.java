package com.redhat.project.rest;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.redhat.project.data.RunnerRepository;
import com.redhat.project.model.Order;
import com.redhat.project.model.Runner;

@Path("/")
@Stateless
@RolesAllowed("Runner")
public class RunnerRESTService {
	
	@Inject
	RunnerRepository runnerRepo;
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("markOrder")
	public String markOrder(Runner runner) {
		runnerRepo.saveRunner(runner); 
		if(runner.getStatus() == "available") {
			runner.getOrder().setOrderStatus("delivered");
			return "Order Marked Successfully";
		}
		return "Error has Occured";
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getTrips/{id}")
	public int getNumberOfTrips(@PathParam("id") int id) {
		Runner runner = runnerRepo.findRunnerById(id);
		int numOfTrips = 0;
		if(runner.getOrder().getOrderStatus() == "delivered") {
			numOfTrips ++;
			return numOfTrips;
		}
		throw new IllegalArgumentException("Error has occured"); 
	}
	
}
