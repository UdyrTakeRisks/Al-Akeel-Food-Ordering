package com.redhat.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int Id;
	
	String[] Item;
	
	double total_price;
	
	@ManyToOne
	@JoinColumn(name="runnerId")
	Runner runner; 
	
	@ManyToOne
	@JoinColumn(name="restaurantId")
	Restaurant restaurant; 
	
	
	String order_status; // preparing, delivered, canceled
	
}
