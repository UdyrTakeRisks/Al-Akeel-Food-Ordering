package com.redhat.project.data;

import java.util.Set;

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
	
	public void saveMeals(Restaurant restaurant, Set<Meal> meals) {
		 try {
		        if (meals != null) {     
		            
		        	for(Meal meal : meals) {
		        		//entityManager.merge(meal); 
		        		meal.setRestaurant(restaurant);
		        		entityManager.persist(meal); 
		        	}
		        }
		    } catch (Exception e) {
		        throw new EJBException(e); 
		  }
	}

	
}
