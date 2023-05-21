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
	private int Id;
	
	private String[] Items;
	
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
	
	public String[] getItem() {
		return Items;
	}
	
	public double getTotalPrice() {
		return total_price;
	}
	
	public String getOrderStatus() {
		return order_status;
	}
	
	//setters
	
	public void setId(int Id) {
		this.Id = Id;
	}
	
	public void setItem(String[] Items) {
		this.Items = Items;
	}
	
	public void setPrice(double total_price) {
		this.total_price = total_price; 
	}

	public void setOrderStatus(String order_status) {
		this.order_status = order_status;
	}  
}
