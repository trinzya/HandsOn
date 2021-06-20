package com.patientintakesystem;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;


@SpringBootApplication
public class PatientIntakeSystemApplication { 
	private static final Logger LOGGER = LoggerFactory.getLogger(ClinicCalendar.class);
	
	public static String addAppointment() throws DoctorNotFoundException , PastDateException {
		Scanner sc = new Scanner(System.in);
	
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
	         System.out.println("In Added Appointstment"); 
			
			System.out.println("Enter the Follwoing details for Booking an appoitmnet");
			System.out.println("Enter Patient Id");
			int p_id = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter Patient name");
			String p_name = sc.nextLine(); 
			System.out.println("Enter Doctor name");
			String p_doc_name = sc.nextLine(); 
			
	
			System.out.println("Enter Apointment Date");
			
			Calendar calendar = Calendar.getInstance();
			System.out.println(sdf.format(calendar.getTime()));
		    Date enteredDate=null;
		    try {
		     enteredDate = sdf.parse(sc.nextLine()); 
		  
		    }catch (Exception ex)
		    {
		        // enteredDate will be null if date="287686";
		    }
		    Date currentDate = new Date();      
		    if(enteredDate.before(currentDate)){
		        System.out.println("before ");
		        throw new PastDateException("Date Should be future");
		        
		    }
		    

		    for (Doctor d : Doctor.values()) {
		        if (d.name().equalsIgnoreCase(p_doc_name)) {
		        	 List<PatientAppointment> pList=	   viewAllApointment();
		        	 if(pList!=null) {
		        		 
		 		    for(PatientAppointment p_:pList) {
		 		    	if(p_.getP_id() == p_id) {
		 		    		LOGGER.info("Updating Appointment");
		 		    		p_.setAppoitment(enteredDate);
		 		    		p_.setD(p_doc_name);
		 		    		return "Patient Appoitment Updated"; 
		 		    		
		 		    }
		 		    }
		        	 }
		 		    
		 		    PatientAppointment p = new PatientAppointment(p_id,p_name,enteredDate,p_doc_name);
		 		 
		 		    ClinicCalendar c = new ClinicCalendar();
		 		    c.addAppointment(p);
		 		
		 	return "Patient Appoitment Added";	
		        }
		        	
		    }
		    
		    throw new DoctorNotFoundException("No Doctor Found with  name"+p_doc_name);
		   
		   	
			
	
	}
	public static 	List<PatientAppointment> viewAllApointment() {
		ClinicCalendar c = new ClinicCalendar();
	List<PatientAppointment>	pList=ClinicCalendar.viewAllAppointment();
	return pList;
		
	}

	public static void main(String[] args) {
		SpringApplication.run(PatientIntakeSystemApplication.class, args); 
	
		
		System.out.println("Welcome to Patient Intake Stystem");
		
		LOGGER.info("In Main");
		LOGGER.info("Welcome to Patient Intake Stystem");
		Scanner sc = new Scanner(System.in);
	int ch;
	do {
			System.out.println("Choose 1 for Book an Appoitment \n 2 for View All appoitmnet\n 3 for exit");
			 ch = sc.nextInt();
			if(ch==1) {
		try {
			String result=	addAppointment();
			LOGGER.info(result);
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			LOGGER.error("Exception ocuured");
		}		
		
	
			
			
			
			
			
			
		}
		else if(ch==2){
			List<PatientAppointment> pList=	viewAllApointment();
			LOGGER.info("All Appoitnment {}",pList);
			System.out.println("All Appointmnet"+pList);
		}
			
		else {
			LOGGER.info("exit");
		}
	}	while(ch!=3);
		
		
		
		
		
	}

}
