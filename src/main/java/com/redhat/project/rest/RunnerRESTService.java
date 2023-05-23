package com.redhat.project.rest;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.redhat.project.model.Order;
import com.redhat.project.model.Runner;

@Path("/")
@Stateless
@RolesAllowed("Runner")
public class RunnerRESTService {
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("markOrder")
	public void markOrder(Runner runner) {
		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getTrips/{id}")
	public Runner getNumberOfTrips(@PathParam("id") int id) {
		return null; 
	}
	
}
