package com.cognizant.flightmanagement.repository;
//import nescessary packages
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.flightmanagement.model.Passenger;
@Repository
public interface IPassengerRepository extends JpaRepository<Passenger, String> {
	//This function is used to filter the passenger based on column  Vip
	public List<Passenger>   findByVip(boolean vip);
	

}
