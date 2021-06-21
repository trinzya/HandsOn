package com.cognizant.flightmanagement.controller;


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
	
	
	@RequestMapping("/")
	public String viewHome() {
		LOGGER.info("In Home Page");
		return "index";
		
		
		
	}
	
	@RequestMapping("/viewallflights")
	public String viewAllFlights(Model map) {
		LOGGER.info("in view all flight");
		List<Flight> list = flightService.getAllFlight();
		map.addAttribute("flightList",list);
		
		return "viewAllFlights";
		
			
	}
	
	@RequestMapping("/viewallecoflights")
	public String viewAllEcoFlights(Model map) {
		LOGGER.info("in view all Economy flight");
		List<Flight> list = flightService.getAllByFlightType("Economy");
		System.out.println("List"+list);
		map.addAttribute("flightList",list);
		
		return "viewAllEcoFlights";
		
			
	}
	@RequestMapping("/viewallbusflights")
	public String viewAllBusFlights(Model map) {
		LOGGER.info("in view all  busniess flight");
		List<Flight> list = flightService.getAllByFlightType("Busniess");
		map.addAttribute("flightList",list);
		
		return "viewAllBusFlights";
		
			
	}
	
	@RequestMapping("/viewallpassengers")
	public String viewAllPassenger(Model map) {
		LOGGER.info("in view all passenger");
		List<Passenger> list = passengerService.getAllPassenger();
		map.addAttribute("passengerList",list);
		return "viewAllPassenger";
		
			
	}
	
	
	@RequestMapping("/viewallvippassengers")
	public String viewAllVipPassenger(Model map) {
		LOGGER.info("in view Vip all passenger");
		List<Passenger> list = passengerService.getAllVipPassenger(true);
		map.addAttribute("passengerList",list);
		return "viewAllViewPassenger";
		
			
	}
	
	@RequestMapping("/viewallnonvippassengers")
	public String viewAllNonVipPassenger(Model map) {
		LOGGER.info("in view non all passenger");
		List<Passenger> list = passengerService.getAllVipPassenger(false);
		map.addAttribute("passengerList",list);
		return "viewAllNonViewPassenger";
		
			
	}
	
	@RequestMapping(value="/addnewflight"  , method=RequestMethod.GET)
	public String viewAddNewFlight(@ModelAttribute Flight flight) {
		return "newflight";
		
		
		
	} 
	
	@RequestMapping(value="/addnewpassenger"  , method=RequestMethod.GET)
	public String viewAddNewPassenger(@ModelAttribute Passenger passenger) {
		return "newpassenger";
		
		
		
	}
	
	@RequestMapping(value="/addflight", method=RequestMethod.POST)
	public String saveFlight(Flight f) {
		
		LOGGER.info("hello in create");
		LOGGER.info(flightService.createFlight(f));
		return "redirect:/viewallflights";
	}
	
	@RequestMapping(value="/addpassenger", method=RequestMethod.POST)
	public String savePassenger(Passenger p) {
		
		LOGGER.info("hello in create");
		LOGGER.info(passengerService.createPassenger(p));
		return "redirect:/viewallpassengers";
	}
	
	@ModelAttribute("type")
	public List<String> flightType() {
		List<String> type=new ArrayList<String>();
		type.add("Economy");
		type.add("Busniess");
		
		return type;
	
	}
	@ModelAttribute("isVip")
	public List<String> PassengerType() {
		List<String> type=new ArrayList<String>();
		type.add("Yes");
		type.add("No");
		
		return type;
	
	}  
	@RequestMapping(value = "/viewpassengertoflight",method = RequestMethod.GET)
	public String viewPassengerToFlight(Model map,String id) {
		
		Flight f= flightService.getFlightById(id);
		
		map.addAttribute("flight",f);
		map.addAttribute("passengers",f.getPassengers());
		return "viewpassengertoflight"; 
		
	}
	@RequestMapping(value = "/addpassengertoflight",method = RequestMethod.GET)
	public String addPassengerToFlight(Model map,String id) {
		List<Passenger> p = passengerService.getAllPassenger();
		map.addAttribute("passengerList",p);
		Flight f= flightService.getFlightById(id);
		map.addAttribute("flight",f);
		return "addpassengertoflight"; 
		
	}
	
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
	
	
	@RequestMapping(value = "/removed",method = RequestMethod.POST)
	public String removedPassengerToFlight(String f_id, String p,Model m) {
		LOGGER.info("in function");
		LOGGER.info(f_id+p);
		Flight f= flightService.getFlightById(f_id);
		Passenger passenger =passengerService.getPassengerById(p); 
	String result=	flightService.removePassenger(f, passenger);
	if(result==null) {
		m.addAttribute("result", "Non - Vip Paasegers cannot be removed");
		return "error";
	}
	else {
		
		return "redirect:/viewallflights";
	}
	
	
		
	}
}
