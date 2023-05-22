package com.redhat.project.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Restaurant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	 
	private String name;
	
	private int ownerId;
	
	@OneToMany(mappedBy="restaurant") 
	private Set<Meal> list_of_meals;  
	
	@OneToMany(mappedBy="restaurant")
	private Set<Order> orders;
	
	
	//getters  
	
	public int getId() {
		return Id;
	}
	
	public String getName() {
		return name;
	}
	
	public int getOwnerId() {
		return ownerId;
	}
	
	public Set<Meal> getMeals() {
		return list_of_meals;
	}
	
	public Set<Order> getOrders() {
		return orders;
	}
	
	//setters
	
	public void setId(int Id) {
		this.Id = Id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId; 
	}
	
	public void setMeals(Set<Meal> list_of_meals) {
		this.list_of_meals = list_of_meals;
	}
	
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	
}
 