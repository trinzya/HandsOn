package com.cognizant.flightmanagement.model;

//import necessary packages

import java.util.List;


import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;




@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Flight {
@Id	
private String id;
private  String flightType;
//to establish the realtionship between flight  and passenger
@OneToMany
private List<Passenger> passengers;




// This function is used to add the passenger in the lsit 
public boolean addPassenger(Passenger p) {
	return passengers.add(p);
}

//This function is used to remove the passenger from the lsit.
public boolean removePassenger(Passenger p) {
	return passengers.remove(p);
	
}
}
