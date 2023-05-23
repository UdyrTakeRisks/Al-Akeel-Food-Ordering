package com.redhat.project.data;

import javax.ejb.EJBException;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.redhat.project.model.Order;
import com.redhat.project.model.Restaurant;
import com.redhat.project.model.User;

import java.util.List;

@ApplicationScoped
public class OrderRepository {
	
	
	@PersistenceContext    
	private EntityManager entityManager;
	
	public List<Order> listAllOrdersForCustomer(int id) {
		 
		TypedQuery<Order> query =
				//entityManager.createQuery("SELECT i FROM Order i where i.id = :id", Order.class);
				entityManager.createQuery("SELECT i.Items FROM Order i", Order.class);
		//query.setParameter("id", id);
		
		return query.getResultList(); 
	}
	
	public void saveOrder(Order order, Restaurant res) {
		 try {
		        if (order != null) {
		        	order.setRestaurant(res);
		            //entityManager.persist(order);
		        }
		    } catch (Exception e) {
		        throw new EJBException(e); 
		  }
	}
	
	public void editOrder(Order order) {
		 try {
		        if (order != null) {
		            entityManager.merge(order); 
		            //entityManager.persist(restaurant.getMeals());
		        }
		    } catch (Exception e) {
		        throw new EJBException(e); 
		  }
	}
} 
