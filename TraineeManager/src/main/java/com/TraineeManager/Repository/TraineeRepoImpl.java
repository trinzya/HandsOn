package com.TraineeManager.Repository;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TraineeManager.model.Cohort;
import com.TraineeManager.model.Trainee;

@Service
public class TraineeRepoImpl  {
	@Autowired
	private TraineeRepo repo;
	@Autowired
	private CohortRepoImpl cohortRepoImpl;
	
	//This is to used to store a trainee object in the database
	public  String  createTrainee(Trainee p ) {
		repo.saveAndFlush(p);
		
		return "Trainee Created";
		
		
		
	} 
	

	
	//This is to used to get all the trainees from  the database
	public  List<Trainee>  getAllTrainee(){ 
		
		return repo.findAll();
		
	}
	//This is to used to get all the trainees from  the database filter by traineeName 
	public  List<Trainee> getTraineeBytraineeName(String traineeName) {
	 return repo.findByName(traineeName);
		
	} 
	
	//This object is used to remove the trainee from the databased on the "id" which is the primary key.
	public  String removeTrainee(int id) {
		
		Optional<Trainee> result = repo.findById(id);
		if(result.isPresent()) {
	
		List<Cohort> list=	cohortRepoImpl.getAllCohort();
		for (Cohort c: list) {
			
		}
			
			
			
			
			repo.delete(result.get());
			return "Deleted";
		}
		else {
			
			return ("Trainee not there");
		} 
		
		
		
	}
	
	//This function returns the Trainee who has the paticular "id"
	public Trainee getById(int id)
	{Optional<Trainee> result = repo.findById(id);
	if(result.isPresent()) 
		return result.get();
	return null;
		
		
	}


}


	

