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
	
	
	public  String  createTrainee(Trainee p ) {
		repo.saveAndFlush(p);
		
		return "Trainee Created";
		
		
		
	} 
	

	
	
	public  List<Trainee>  getAllTrainee(){ 
		
		return repo.findAll();
		
	}
	
	public  List<Trainee> getTraineeBytraineeName(String traineeName) {
	 return repo.findByName(traineeName);
		
	} 
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
	
	
	public Trainee getById(int id)
	{Optional<Trainee> result = repo.findById(id);
	if(result.isPresent()) 
		return result.get();
	return null;
		
		
	}


}


	

