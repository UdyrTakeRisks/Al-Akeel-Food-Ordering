// Meal Entity
package com.redhat.project.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Meal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	 
	private String name;
	
	private double price;
	
	
	
	
	@ManyToOne(fetch = FetchType.EAGER)  
	@JoinColumn(name="restaurantId")
	@JsonIgnore
	private Restaurant restaurant; 
	
//	@ManyToOne
//	@JoinColumn(name="orderId") 
//	@JsonIgnore 
//	private Order order;
	
	//getters  
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public Restaurant getRestaurant() {
		return restaurant;
	}
	
//	public Order getOrder() {
//		return order;
//	}
	
	//setters
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	 
	public void setPrice(double price) {
		this.price = price;
	}
	
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	
//	public void setOrder(Order order) {
//		this.order = order;
//	}
}
 