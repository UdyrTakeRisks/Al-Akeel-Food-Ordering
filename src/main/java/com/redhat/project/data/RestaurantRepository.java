package com.redhat.project.data;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.redhat.project.model.Restaurant;

@ApplicationScoped
public class RestaurantRepository {
	
	@Inject
	private EntityManager entityManager;
	
	public Restaurant findById(int id) {
		return entityManager.find(Restaurant.class, id);
	}
}
 