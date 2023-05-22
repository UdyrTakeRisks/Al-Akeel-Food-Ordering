package com.redhat.project.data;

import javax.ejb.EJBException;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.redhat.project.model.Meal;
import com.redhat.project.model.Restaurant;

@ApplicationScoped
public class MealRepository {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public Meal findMealById(int id) {
		return entityManager.find(Meal.class, id);
	} 
	
	public void saveMeals(Restaurant restaurant) {
		 try {
		        	for (Meal meal : restaurant.getMeals()) {
		        	    meal.setRestaurant(restaurant);
		        	   // entityManager.persist(meal); 
		        	}
		        
		    } catch (Exception e) {
		        throw new EJBException(e); 
		  }
	}

	
}
