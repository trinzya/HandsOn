package com.cognizant.flightmanagement.model;

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
	

	public String getName() {
		return name;
	}
	
	public  boolean isVip() {
		return vip;
	}

	


}
