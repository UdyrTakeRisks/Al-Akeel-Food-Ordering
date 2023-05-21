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
	
}
 