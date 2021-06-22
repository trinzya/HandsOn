package com.cognizant.flightmanagement.serivce;
//import necessary packages
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.flightmanagement.model.Flight;
import com.cognizant.flightmanagement.model.Passenger;
import com.cognizant.flightmanagement.repository.IPassengerRepository;


@Service
public class PassengerService { 
	private static int count =0;
	

	
	@Autowired
	private IPassengerRepository passengerrepo;
	@Autowired 
	private FlightService flightService;
	
	//This function is used to store the passenger in the database.
	public  String  createPassenger(Passenger p ) {
		passengerrepo.saveAndFlush(p);
		PassengerService.count=PassengerService.count+1;
		return "Passenger Created";
		
		
		
	} 
	

	
	//The function is used to get All the passengers from the database
	public  List<Passenger>  getAllPassenger(){ 
		
		return passengerrepo.findAll();
		
	}
	
	//The function is used to get All the passengers from the database filter by vip column
	public  List<Passenger>  getAllVipPassenger(boolean vip){ 
		
		return passengerrepo.findByVip(vip);
		
	}
	
	//The function is used to get a particular passenger from the database using the primary key "id".
	//It check if the passenger with a particualr id is there or not.
	//if the passenger is avialable it return the passenger object otherwise return null;
	public  Passenger getPassengerById(String id) {
		Optional<Passenger> result = passengerrepo.findById(id);
		if(result.isPresent()) {
			return result.get();
		}
		else {
			System.out.println("Passenger not there");
			return null;
		}
	} 
	
	//The function is used t remove a particular Passenger.
	// Its  get a particular passenger from the database using the primary key "id".
	//It check if the passenger is store in the database or not.
	//if the passenger is avialable it gets deleted.;
	public  String removePassenger(String id) {
		
		Optional<Passenger> result = passengerrepo.findById(id);
		if(result.isPresent()) {
		List<Flight> list=	flightService.getAllFlight();
		
			
			
			
			
			passengerrepo.delete(result.get());
			return "Deleted";
		}
		else {
			
			return ("Passenger not there");
		}
		
	}

}
