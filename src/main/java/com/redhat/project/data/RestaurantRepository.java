package com.redhat.project.data;

import javax.ejb.EJBException;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import java.util.List;
import java.util.Set;

import com.redhat.project.model.Meal;
import com.redhat.project.model.Restaurant;

@ApplicationScoped
public class RestaurantRepository {
	

	@PersistenceContext
	private EntityManager entityManager;
	
	public Restaurant findById(int id) {
		return entityManager.find(Restaurant.class, id);
	}
	
	public List<Restaurant> getAllRestaurants() {
		TypedQuery<Restaurant> query = 
				entityManager.createQuery("SELECT r FROM Restaurant r", Restaurant.class);
		
		return query.getResultList(); 
	}
	
	public void saveRestaurant(Restaurant restaurant, Set<Meal> meals) {
		 try {
		        if (restaurant != null) {
		        	//restaurant.setMeals(meals);
		        	//entityManager.merge(meals);
		        	for(Meal meal : meals )
		        		meal.setRestaurant(restaurant);
		            
		        	restaurant.setMeals(meals);
		            //entityManager.persist(restaurant.getMeals());
		        }
		    } catch (Exception e) {
		        throw new EJBException(e); 
		  }
		//entityManager.merge(restaurant); 
	} 
	
	
	public void findRestaurant(Restaurant restaurant) {
		entityManager.find(Restaurant.class, restaurant.getId()); 
	}
}
 
