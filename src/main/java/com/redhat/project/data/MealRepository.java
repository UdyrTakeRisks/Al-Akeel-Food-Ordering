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
	
	public void saveMeals(Restaurant restaurant) {
		 try {
<<<<<<< HEAD
		        if (meals != null) {     
		            
		        	//for(Meal meal : meals) {
		        		//entityManager.merge(meal); 
		        		//restaurant.setMeals(meals);
		        	entityManager.persist(restaurant); 
		        		//entityManager.persist(meal); 
		        	//}
		        	entityManager.persist(meals); 
		        }
		    } catch (Exception e) {
		        throw new EJBException(e); 
		  }
	}
	
	public void editMeals(Set<Meal> meals) {
		 try {
		        if (meals != null) {     
		            
		        	for(Meal meal : meals) {
		        		//entityManager.merge(meal); 
		        		//meal.setRestaurant(restaurant);
		        		entityManager.merge(meal); 
=======
		        	for (Meal meal : restaurant.getMeals()) {
		        	    meal.setRestaurant(restaurant);
		        	   // entityManager.persist(meal); 
>>>>>>> 952327bb0cc575cae351657b57b10d04a9f17088
		        	}
		        
		    } catch (Exception e) {
		        throw new EJBException(e); 
		  }
	}

	
}
