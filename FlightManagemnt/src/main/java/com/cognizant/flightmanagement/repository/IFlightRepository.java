package com.cognizant.flightmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.flightmanagement.model.Flight;
@Repository
public interface IFlightRepository  extends JpaRepository<Flight, String>{

public 	List<Flight> findByFlightType(String type);
	/* public List<Flight> findByFlightType(String type); */
	

}
