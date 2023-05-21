package com.redhat.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Meal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int Id;
	 
	String name;
	
	double price;
	
	
	@ManyToOne 
	@JoinColumn(name="restaurantId")
	Restaurant restaurant; 
}
 