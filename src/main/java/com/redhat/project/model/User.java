package com.redhat.project.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	   
	String name; 
	
	String role; 
	
	@OneToMany(mappedBy="user", fetch=FetchType.EAGER)
	@JsonIgnore
	Set<Order> orders;
	
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
	public Set<Order> getOrders() {
		return orders;
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
	
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

}
