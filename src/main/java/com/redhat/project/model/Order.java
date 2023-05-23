package com.redhat.project.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
                                             	
	@JsonProperty("Items")
	//@JsonIgnore 
	@Transient //imp
	@OneToMany(mappedBy="order", fetch=FetchType.EAGER, cascade = CascadeType.MERGE)
	private Set<Meal> Items;     // !!!!
	
	@JsonProperty("totalPrice")
	@JsonIgnore
	private double totalPrice;
	
	@OneToOne
	@JsonIgnore
	@Transient //imp
	@JoinColumn(name="runnerId")
	private Runner runner; 
	
	@ManyToOne  
	@JoinColumn(name="restaurantId")
	@Transient //imp
	private Restaurant restaurant;   // !!!!
	
	@JsonProperty("orderStatus")
	private String orderStatus; // preparing, delivered, canceled
	
	@OneToOne  
	@Transient  //imp
	@JoinColumn(name="userId")
	private User user;
	
	//getters 
	
	public int getId() {
		return id;
	}
	
	@JsonIgnore
	public Set<Meal> getItems() {
		return Items;
	}
	
	public double getTotalPrice() {
		return totalPrice;
	}
	
	@JsonIgnore
	public Runner getRunner() {
		return runner;
	}
	
	@JsonIgnore 
	public Restaurant getRestaurant() {
		return restaurant;
	}
	 
	public String getOrderStatus() {
		return orderStatus;
	}
	
	@JsonIgnore
	public User getUser() {
		return user;
	}
	
	//setters
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setItems(Set<Meal> Items) {
		this.Items = Items;  
	}
	 
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice; 
	}
	
	public void setRunner(Runner runner) {
		this.runner = runner;
	}
	
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
}
