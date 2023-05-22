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
	private int Id;
	 
	private String name;
	
	private double price;
	
	
	@ManyToOne 
	@JoinColumn(name="restaurantId")
	private Restaurant restaurant; 
	
	@ManyToOne
	@JoinColumn(name="orderId")
	private Order order;
	
	//getters  
	
	public int getId() {
		return Id;
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
	
	public Order getOrder() {
		return order;
	}
	
	//setters
	
	public void setId(int Id) {
		this.Id = Id;
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
	
	public void setOrder(Order order) {
		this.order = order;
	}
}
 