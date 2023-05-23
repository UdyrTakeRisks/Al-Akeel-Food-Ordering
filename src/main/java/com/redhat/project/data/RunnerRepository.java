package com.redhat.project.data;

import javax.ejb.EJBException;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.redhat.project.model.Restaurant;
import com.redhat.project.model.Runner;

@ApplicationScoped
public class RunnerRepository {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public Runner findRunnerById(int id) {
 		return entityManager.find(Runner.class, id);
	}
	
	public void saveRunner(Runner runner) {
		 try {
		        if (runner != null) {
		            entityManager.merge(runner); 
		            //entityManager.persist(restaurant.getMeals());
		        }
		    } catch (Exception e) {
		        throw new EJBException(e); 
		  } 
	}
}
