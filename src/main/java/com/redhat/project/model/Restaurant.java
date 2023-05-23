package com.redhat.project.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Restaurant {    
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	 
	private String name;
	
	private int ownerId;
	
	
	@OneToMany(mappedBy="restaurant", fetch=FetchType.EAGER, cascade = CascadeType.PERSIST) 
	@JsonProperty("listOfMeals") 
	private Set<Meal> listOfMeals;   
	
	@OneToMany(mappedBy="restaurant", fetch=FetchType.EAGER, cascade = CascadeType.PERSIST)   
	@Transient //imp   
	@JsonIgnore
	private Set<Order> orders;  // !!!! 
	
	 
	//getters  
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public int getOwnerId() {
		return ownerId;
	}
	
	@JsonIgnore 
	public Set<Meal> getMeals() {
		return listOfMeals;
	}
	
	@JsonIgnore
	public Set<Order> getOrders() {
		return orders;
	}
	
	//setters
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId; 
	}
	
	public void setMeals(Set<Meal> listOfMeals) {
		this.listOfMeals = listOfMeals;
	}
	
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	
}
 