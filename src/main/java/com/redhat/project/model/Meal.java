package com.redhat.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Meal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int Id;
	 
	String name;
	
	double price;
	
	int restaurantId;
}
