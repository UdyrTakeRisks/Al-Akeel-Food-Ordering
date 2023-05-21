package com.redhat.project.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Runner {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int Id;
	 
	String name;
	
	String status; // available, busy
	
	double delivery_fees; 
	
	@OneToMany(mappedBy="runner")
	Set<Order> orders; 
}
 