package com.redhat.project.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	
	@OneToMany(mappedBy="order")
	private Set<Meal> Items;
	
	private double total_price;
	
	@ManyToOne
	@JoinColumn(name="runnerId")
	private Runner runner; 
	
	@ManyToOne
	@JoinColumn(name="restaurantId")
	private Restaurant restaurant; 
	
	
	private String order_status; // preparing, delivered, canceled
	
	
	//getters 
	
	public int getId() {
		return Id;
	}
	
	public Set<Meal> getItems() {
		return Items;
	}
	
	public double getTotalPrice() {
		return total_price;
	}
	
	public Runner getRunner() {
		return runner;
	}
	
	public Restaurant getRestaurant() {
		return restaurant;
	}
	 
	public String getOrderStatus() {
		return order_status;
	}
	
	//setters
	
	public void setId(int Id) {
		this.Id = Id;
	}
	
	public void setItems(Set<Meal> Items) {
		this.Items = Items; 
	}
	 
	public void setTotalPrice(double total_price) {
		this.total_price = total_price; 
	}
	
	public void setRunner(Runner runner) {
		this.runner = runner;
	}
	
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public void setOrderStatus(String order_status) {
		this.order_status = order_status;
	}  
}
