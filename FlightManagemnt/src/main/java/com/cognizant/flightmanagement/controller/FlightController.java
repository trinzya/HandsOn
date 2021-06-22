package com.cognizant.flightmanagement.controller;

//import necessary packages
import java.util.ArrayList;
import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



import com.cognizant.flightmanagement.model.Flight;
import com.cognizant.flightmanagement.model.Passenger;
import com.cognizant.flightmanagement.serivce.FlightService;
import com.cognizant.flightmanagement.serivce.PassengerService;

@Controller
public class FlightController {  
	private static final Logger LOGGER = LoggerFactory.getLogger(FlightController.class);
	@Autowired
	private FlightService flightService;
	
	@Autowired
	private PassengerService passengerService;
	
	//The function is used to view the index or home of the website.
	@RequestMapping("/")
	public String viewHome() {
		LOGGER.info("In Home Page");
		return "index";
		
		
		
	}
	
	
	//The function is used to view the information about  all the flights that are stored in the database.
	@RequestMapping("/viewallflights")
	public String viewAllFlights(Model map) {
		LOGGER.info("in view all flight");
		List<Flight> list = flightService.getAllFlight();
		map.addAttribute("flightList",list);
		
		return "viewAllFlights";
		
			
	}
	//The function is used to view the information about  all the Economy  flights (Fights whose Flight Type is  Economy ) that are stored in the database.
	@RequestMapping("/viewallecoflights")
	public String viewAllEcoFlights(Model map) {
		LOGGER.info("in view all Economy flight");
		List<Flight> list = flightService.getAllByFlightType("Economy");
		System.out.println("List"+list);
		map.addAttribute("flightList",list);
		
		return "viewAllEcoFlights";
		
			
	}
	
	//The function is used to view the information about  all the Business flights (Flights whose Flight Type is  Business ) that are stored in the database.
	@RequestMapping("/viewallbusflights")
	public String viewAllBusFlights(Model map) {
		LOGGER.info("in view all  busniess flight");
		List<Flight> list = flightService.getAllByFlightType("Busniess");
		map.addAttribute("flightList",list);
		
		return "viewAllBusFlights";
		
			
	}
	
	//The function is used to view the information about  all the Passengers that are stored in the database.
	@RequestMapping("/viewallpassengers")
	public String viewAllPassenger(Model map) {
		LOGGER.info("in view all passenger");
		List<Passenger> list = passengerService.getAllPassenger();
		map.addAttribute("passengerList",list);
		return "viewAllPassenger";
		
			
	}
	
	//The function is used to view the information about  all the Vip Passengers that are stored in the database.
	@RequestMapping("/viewallvippassengers")
	public String viewAllVipPassenger(Model map) {
		LOGGER.info("in view Vip all passenger");
		List<Passenger> list = passengerService.getAllVipPassenger(true);
		map.addAttribute("passengerList",list);
		return "viewAllViewPassenger";
		
			
	}
	
	//The function is used to view the information about  all the Non Vip Passengers that are stored in the database.
	@RequestMapping("/viewallnonvippassengers")
	public String viewAllNonVipPassenger(Model map) {
		LOGGER.info("in view non all passenger");
		List<Passenger> list = passengerService.getAllVipPassenger(false);
		map.addAttribute("passengerList",list);
		return "viewAllNonViewPassenger";
		
			
	} 
	//This is function is used to view the form page where the user can input the information about the flight which he/she wish to add and after the user submit the information
	//the controller gets passed to the function  saveFlight. (where actually the flight gets saved to the database)
	@RequestMapping(value="/addnewflight"  , method=RequestMethod.GET)
	public String viewAddNewFlight(@ModelAttribute Flight flight) {
		return "newflight";
		
		
		
	} 
	//This is function is used to view the form page where the user can input the information about the Passenger which he/she wish to add and after the user submit the information
	//the controller gets passed to the function  savePassenger. (where actually the Passenger gets saved to the database)
	@RequestMapping(value="/addnewpassenger"  , method=RequestMethod.GET)
	public String viewAddNewPassenger(@ModelAttribute Passenger passenger) {
		return "newpassenger";	
	}
	
	
	//This function is used to get the information about the flight from the user  which he/she wishes to add and get it saved to the database. 
	//This is has the Request Method Post becuase we are getting information about the user
	@RequestMapping(value="/addflight", method=RequestMethod.POST)
	public String saveFlight(Flight f) {
		
		LOGGER.info("hello in create");
		LOGGER.info(flightService.createFlight(f));
		return "redirect:/viewallflights";
	}
	
	//This function is used to get the information about the passenger from the user  which he/she wishes to add and get it saved to the database. 
	//This is has the Request Method Post becuase we are getting information about the user
	@RequestMapping(value="/addpassenger", method=RequestMethod.POST)
	public String savePassenger(Passenger p) {
		
		LOGGER.info("hello in create");
		LOGGER.info(passengerService.createPassenger(p));
		return "redirect:/viewallpassengers";
	}
	
	
	//This function is just used populate the values the of different flight types on the JSP page 
	@ModelAttribute("type")
	public List<String> flightType() {
		List<String> type=new ArrayList<String>();
		type.add("Economy");
		type.add("Busniess");
		
		return type;
	
	}
	//This function is just used populate the option the Vip  on the JSP page 
	@ModelAttribute("isVip")
	public List<String> PassengerType() {
		List<String> type=new ArrayList<String>();
		type.add("Yes");
		type.add("No");
		
		return type;
	
	}  
	
	//The function is used to view the passengers which are in the particular flight. 
	//The "id" here to is the flight primary key which to used to get the flight object
	@RequestMapping(value = "/viewpassengertoflight",method = RequestMethod.GET)
	public String viewPassengerToFlight(Model map,String id) {
		
		Flight f= flightService.getFlightById(id);
		
		map.addAttribute("flight",f);
		map.addAttribute("passengers",f.getPassengers());
		return "viewpassengertoflight"; 
		
	} 
	
	//This function is used to view the Form page where you can select the passenger wchih you want to add in the flight.
	//After the user click on sumbit it, the controller is passed to the function addedPassengerToFlight(where actually the passenger gets added in the list of passengers of  the flight object
	//The "id" here is again the primary key of the flight object which is to get the flight object.
	@RequestMapping(value = "/addpassengertoflight",method = RequestMethod.GET)
	public String addPassengerToFlight(Model map,String id) {
		List<Passenger> p = passengerService.getAllPassenger();
		map.addAttribute("passengerList",p);
		Flight f= flightService.getFlightById(id);
		map.addAttribute("flight",f);
		return "addpassengertoflight"; 
		
	}
	
	//The function is used to remove the passengers which are in the particular flight. 
	//This function in particular will take the user to  form page where you select the passenger which ahe/she wishes to remove.
	//It will take you to the error page if there are no passengers in the flight.
	//The "id" here to is the flight primary key which to used to get the flight object
	@RequestMapping(value = "/removepassengertoflight",method = RequestMethod.GET)
	public String removePassengerToFlight(Model map,String id) {
		List<Passenger> p = flightService.getAllPassenger(id);
		LOGGER.info("k"+p);
		if(p.size()==0) {
			map.addAttribute("result","No Passneger in this Flight");
			return "error";
		}
			
		else {
			map.addAttribute("passengerList",p);
		Flight f= flightService.getFlightById(id);
		map.addAttribute("flight",f);
		return "removepassengertoflight"; 
		}
		
	}
	
	
	//This function adds the passenger to the flight object and updated the database according.
	//The function used the method post as it taking the values from the user.
	//The f_id here the flight primary key to get the flight object
	//the p is the passenger primary key to get the passenger object
	//It will take the user to the error  page if you wish to add a non vip passnegers in theFlight  object which has flight type bussiness (The conditon was mentioned in the document)
	@RequestMapping(value = "/added",method = RequestMethod.POST)
	public String addedPassengerToFlight(String f_id, String p,Model m) {
		LOGGER.info("in function");
		LOGGER.info(f_id+p);
		Flight f= flightService.getFlightById(f_id);
		Passenger passenger =passengerService.getPassengerById(p); 
	String result=	flightService.addPassenger(f, passenger);
	if(result==null) {
		m.addAttribute("result", "Non - Vip Paasegers cannot be added to Business class");
		return "error";
	}
	else {
		
		return "redirect:/viewallflights";
	}
	
	
		
	}
	//This function remove  the passenger to the flight object and updated the database according.
	//The function used the method post as it taking the values from the user.
	//The f_id here the flight primary key to get the flight object
	//the p is the passenger primary key to get the passenger object
	//It will take you the  error page if you wish to remove a  vip passnegers in theFlight  object  (The conditon was mentioned in the document)
	
	@RequestMapping(value = "/removed",method = RequestMethod.POST)
	public String removedPassengerToFlight(String f_id, String p,Model m) {
		LOGGER.info("in function");
		LOGGER.info(f_id+p);
		Flight f= flightService.getFlightById(f_id);
		Passenger passenger =passengerService.getPassengerById(p); 
	String result=	flightService.removePassenger(f, passenger);
	if(result==null) {
		m.addAttribute("result", "Vip Paasegers cannot be removed");
		return "error";
	}
	else {
		
		return "redirect:/viewallflights";
	}
	
	
		
	}
}
