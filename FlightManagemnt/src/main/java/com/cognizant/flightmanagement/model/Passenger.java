package com.cognizant.flightmanagement.model;

//import the necessary packages
import java.util.List;

import javax.persistence.Entity;

import javax.persistence.Id;

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
public class Passenger {
	@Id
	private String id;
	private String name;
	private  boolean vip; 
	
	//In the document it was to mentioned to have thses functions
	//This function is used to get the name of the passengers
	public String getName() {
		return name;
	}
	//This function is to check whether the passenger is vip or not .
	public  boolean isVip() {
		return vip;
	}

	


}
