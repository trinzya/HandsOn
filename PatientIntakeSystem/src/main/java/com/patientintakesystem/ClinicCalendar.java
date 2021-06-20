package com.patientintakesystem;


import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ClinicCalendar { 
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ClinicCalendar.class);
	
	
	
	private static List<PatientAppointment> pList = new ArrayList<PatientAppointment>();
	
	
	public  void addAppointment(PatientAppointment p) {
		pList.add(p);
		LOGGER.info("Appointent Added for patient {}",p.getName());
		System.out.println("Appointent Added for patient"+p.getName());
		
	} 
	
	public  void removeAppointment(PatientAppointment p) {
		pList.remove(p);
		LOGGER.info("Appointent removed for patient {}",p.getName());
		System.out.println("Appointent removed for patient"+p.getName());
		
	} 
	
	public static  List<PatientAppointment> viewAllAppointment() { 
		LOGGER.info("appointemnt={}", pList);

		LOGGER.info("End");
		return pList;
		
		
		
	}

}
