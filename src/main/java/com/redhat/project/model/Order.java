package com.redhat.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int Id;
	
	String[] Item;
	
	double total_price;
	
	int runnerId;
	
	int restaurantId;
	
	String order_status;
	
}
