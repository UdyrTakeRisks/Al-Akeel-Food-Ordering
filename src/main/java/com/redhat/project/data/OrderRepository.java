package com.redhat.project.data;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.redhat.project.model.Order;
import com.redhat.project.model.User;

import java.util.List;

@ApplicationScoped
public class OrderRepository {
	
	User user;
	
	@PersistenceContext    
	private EntityManager entityManager;
	
	public List<Order> listAllOrdersForCustomer(int id) {
		 
		TypedQuery<Order> query =
				entityManager.createQuery("SELECT i FROM Order i where i.id = :id", Order.class);
		query.setParameter("id", id);
		
		return query.getResultList(); 
	}
}
