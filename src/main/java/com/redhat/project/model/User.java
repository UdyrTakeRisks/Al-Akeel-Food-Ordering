package com.redhat.project.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	   
	String name; 
	
	String role; 
	
	@OneToOne(mappedBy="user")
	@Transient //imp
	@JsonIgnore
	Order order;
	
	//getters  
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getRole() {
		return role;
	}
	 
	@JsonIgnore
	public Order getOrders() {
		return order;
	}
	
	//setters
	
	public void setId(int Id) {
		this.id = Id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	public void setOrders(Order order) {
		this.order = order;  
	}

}
