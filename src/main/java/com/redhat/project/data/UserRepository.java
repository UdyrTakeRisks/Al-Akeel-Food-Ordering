package com.redhat.project.data;

import javax.ejb.EJBException;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.redhat.project.model.Restaurant;
import com.redhat.project.model.User;

@ApplicationScoped
public class UserRepository {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public User findUserById(int id) {
		return entityManager.find(User.class, id); 
	}
	
	public void saveUser(User user) {
		
		 try {
		        if (user != null) {
		            entityManager.persist(user);  
		        }
		    } catch (Exception e) {
		        throw new EJBException(e); 
		  }
	}
}
