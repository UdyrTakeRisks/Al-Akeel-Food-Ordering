package com.redhat.project.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Runner { 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	 
	private String name;
	
	private String status; // available, busy
	
	@JsonIgnore
	private double delivery_fees; 
	
	@OneToOne(mappedBy="runner")
	@JsonIgnore
	@Transient //imp
	private Order order;  
	
	//getters  
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getStatus() {
		return status;
	} 
	
	public double getDeliveryFees() {
		return delivery_fees;
	}
	
	public Order getOrder() {
		return order;
	}
	
	
	//setters
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public void setDeliveryFees(double delivery_fees) {
		this.delivery_fees = delivery_fees;
	}
	
	public void setOrder(Order order) {
		this.order = order;
	}
	
}
 