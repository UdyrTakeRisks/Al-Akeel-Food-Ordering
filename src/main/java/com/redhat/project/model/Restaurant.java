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
	int Id;
	 
	String name;
	
	int ownerId;
	
	@OneToMany(mappedBy="restaurant") 
	Set<Meal> list_of_meals;  
	
	@OneToMany(mappedBy="restaurant")
	Set<Order> orders;
	
}
