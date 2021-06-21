package com.TraineeManager.Repository;

import java.util.List;



import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TraineeManager.model.Cohort;
import com.TraineeManager.model.Trainee;
import com.TraineeManager.TraineeManagerApplication;
import com.TraineeManager.Exception.*;

@Service
public class CohortRepoImpl {

	@Autowired
	private CohortRepo repo;
	
	public  String  createCohort(Cohort p ) {
		repo.saveAndFlush(p);
		
		return "Cohort Created";
		
		
		
	} 
	

	
	
	public  List<Cohort>  getAllCohort(){  
		System.out.println("hello");
		System.out.println("x"+repo.findAll());
		return repo.findAll();
		
	}
	
	public  Cohort getCohortById(String id) {
		Optional<Cohort> result = repo.findById(id);
		if(result.isPresent()) {
	
			
			
			
			
			return (result.get());
			
		}
		else {
			return null;
		
		}
		
		
	} 
	public  String removeCohort(String id) {
		
		Optional<Cohort> result = repo.findById(id);
		if(result.isPresent()) {
	
			
			
			
			
			repo.delete(result.get());
			return "Deleted";
		}
		else {
			
			return ("Cohort not there");
		}
		
	}  
	
	public List<Trainee>  getAllTrainee(String id){
		Optional<Cohort> result = repo.findById(id);
		if(result.isPresent()) {
			List<Trainee> l= result.get().getTrainees();
			return l;
		}
		else {
			return null;
		}
	
			
		
	} 
	public  String updateCohort(Cohort s) { 
		/*
		 * Optional<Flight> op = repo.findById(s.getId()); if(op.isPresent()) { Flight
		 * stu = op.get(); stu.setMarks(s.getMarks()); repo.saveAndFlush(stu); return
		 * "Flight UPdated"; } else { return "Flight not found"; }
		 */
		Optional<Cohort> op = repo.findById(s.getCohort_code());
		if(op.isPresent()) {
		 repo.saveAndFlush(s);
		 System.out.println("jy"+op.get());
		 return "Cohort updated";
		}
		else {
			 return null;
		}
		
	}
	
	public boolean getAllTraineeByName(String id,String name){
		Optional<Cohort> result = repo.findById(id);
		if(result.isPresent()) {
			List<Trainee> l= result.get().getTrainees();
		for(Trainee t:l) {
			if(t.getTraineeName().equalsIgnoreCase(name))
				return true;
		
			else
				return false;
		}
		}
		
		return false;
	
			
		
	} 
	
	public String addTraineetoCohort(String id , Trainee t)  throws InvalidTraineeException{ 
		Optional<Cohort> c=repo.findById(id);
		

		
	
	
	System.out.println("hello_");
	System.out.println(c.get());
	c.get().addTrainee(t);
	System.out.println("hello_");
 updateCohort(c.get());
	return "Trainne added";
	
		
	}
 
}
