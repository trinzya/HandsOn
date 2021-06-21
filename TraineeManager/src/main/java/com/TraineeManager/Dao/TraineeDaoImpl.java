package com.TraineeManager.Dao;

import java.text.SimpleDateFormat;


import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.TraineeManager.Exception.InvalidTraineeDataException;
import com.TraineeManager.Exception.InvalidTraineeException;

import com.TraineeManager.Repository.CohortRepoImpl;
import com.TraineeManager.Repository.TraineeRepoImpl;
import com.TraineeManager.model.Cohort;
import com.TraineeManager.model.Trainee;
import  com.TraineeManager.util.Validation;


@Component
public class TraineeDaoImpl implements TraineeDao  {
	
private static final Logger LOGGER = LoggerFactory.getLogger(TraineeDaoImpl.class);

@Autowired
private CohortRepoImpl cohortRepo;

@Autowired
private TraineeRepoImpl traineeRepo;
	
	public String addTrainee() throws InvalidTraineeDataException {
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	Scanner sc = new Scanner(System.in);
	while(true) {
	LOGGER.info("Add a Trainne");
	LOGGER.info("Enter  Emp Id");

	int id = sc.nextInt();
	if(!Validation.validEmpId(id)) {
		LOGGER.error("Enter 6 digits");
		continue;
	}
	sc.nextLine();
	LOGGER.info("Add a Trainne name"); 
	String name= sc.nextLine();
	LOGGER.info("Add a Email");
	String email = sc.nextLine();
	if(!Validation.validEmail(email)) {
		LOGGER.error("Enter valid email address");
		continue;
		
	}
	LOGGER.info("Add Date of joining");
	  Date dateOfJoining=null;
	    try {
	    	dateOfJoining = sdf.parse(sc.nextLine()); 
	  
	    }catch (Exception ex)
	    {
//	         enteredDate will be null if date="287686";
	    }
	    Date currentDate = new Date();      
	    if(dateOfJoining.after(currentDate)){
	       LOGGER.info("before ");
	        throw new InvalidTraineeDataException("Date Should be future");
	        
	    }
	
	 Trainee t = new Trainee(id,name,dateOfJoining,email);
	 String result = traineeRepo.createTrainee(t);
	 return result;

	
	}
	
	
	
	
	}
	
	public String removeTrainee() {
		Scanner sc = new Scanner(System.in);
		while(true) {
		LOGGER.info("Remove a Trainne");
		LOGGER.info("Enter Emp Id");
		int id = sc.nextInt();
		if(!Validation.validEmpId(id)) {
			LOGGER.error("Emp id size should be 6 digits");
			continue;
		}
		String result = traineeRepo.removeTrainee(id);
	
		 return result; 
		}
	}
	
	public String getAllTraineefromCohort(){
		Scanner sc = new Scanner(System.in);
      while(true) {
		LOGGER.info("Enter cohort Id");
		List<Cohort> c=cohortRepo.getAllCohort();
		LOGGER.info("THe the list cohort are {}",c);
		String id = sc.nextLine();
		if(!Validation.validCohort_code(id)) {
			LOGGER.error("Enter valid Cohort Code in format Cohort code should be in the following format, "
					+ "AAAXXAAXX, A is for alphabet and X is for number");
			continue;
		}
		LOGGER.info("Get a List of Trainne from {}",id);
	List<Trainee>	tList= cohortRepo.getAllTrainee(id);
	LOGGER.info("The Trainee in Cohort{} are {}",id,tList);
		return "List found";
	}
	}
	
	public String  findByNameInCohort() {
		Scanner sc = new Scanner(System.in);
	      while(true) {
		LOGGER.info("Enter Cohort Id");
		List<Cohort> c=cohortRepo.getAllCohort();
		System.out.println(c);
		LOGGER.info("THe the list cohort are {}",c);
		String id = sc.nextLine();
		if(!Validation.validCohort_code(id)) {
			LOGGER.error("Enter valid Cohort Code in format Cohort code should be in the following format, "
					+ "AAAXXAAXX, A is for alphabet and X is for number");
			continue;
		}
		LOGGER.info("Enter Name to find");
		String name = sc.nextLine();
		if(cohortRepo.getAllTraineeByName(id, name))
			return "Trainee "+name+" is present in Cohort " +id;
		else {
			return "Trainee "+name+" is not present in Cohort " +id;
		}
	      }
	}

	@Override
	public String addTraineeToCohort()  {
	
		Scanner sc = new Scanner(System.in);
	while(true) {	
		
		List<Cohort> c=cohortRepo.getAllCohort();
		System.out.println(c);
		LOGGER.info("THe the list cohort are {}",c);
		LOGGER.info("Enter Id");
		String id = sc.nextLine();
		if(!Validation.validCohort_code(id)) {
			LOGGER.error("Enter valid Cohort Code in format Cohort code should be in the following format, "
					+ "AAAXXAAXX, A is for alphabet and X is for number");
		continue;
		}
		LOGGER.info("Enter trainee Id");
		int t_id = sc.nextInt();
		if(!Validation.validEmpId(t_id)) {
		LOGGER.error("Emp id size should be 6 digits");
		continue;
		}
		Trainee t= traineeRepo.getById(t_id);
		String result=null;
		try {
			LOGGER.info("Add trainee");
			result =cohortRepo.addTraineetoCohort(id,t);
			LOGGER.info(result);
		} catch (InvalidTraineeException e) {
			
			LOGGER.error("Exception ocuured {}",e);
		}
		return result;
		
	}   
		
	}
}
	
	
	
	
	

