package com.redhat.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int Id;
	  
	String name;
	
	String role; 
	
	//getters  
	
	public int getId() {
		return Id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getRole() {
		return role;
	}
	 
	//setters
	
	public void setId(int Id) {
		this.Id = Id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setRole(String role) {
		this.role = role;
	}

}
