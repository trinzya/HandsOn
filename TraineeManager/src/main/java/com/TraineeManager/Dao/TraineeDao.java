package com.TraineeManager.Dao;

import java.util.List;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.TraineeManager.Exception.InvalidTraineeDataException;
import com.TraineeManager.model.Trainee;



public interface TraineeDao  { 
//	private static final Logger LOGGER = LoggerFactory.getLogger(TraineeDao.class);
	
	
	public String addTrainee() throws InvalidTraineeDataException;
		
	public String removeTrainee() ; 
	
	
	public String  getAllTraineefromCohort();  
	
	
	public String  findByNameInCohort();
	
	public String addTraineeToCohort(); 
	
		
	

}
