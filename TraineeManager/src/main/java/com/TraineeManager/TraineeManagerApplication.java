package com.TraineeManager;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.TraineeManager.Dao.TraineeDao;
import com.TraineeManager.Dao.TraineeDaoImpl;
import com.TraineeManager.Exception.InvalidTraineeDataException;


@SpringBootApplication
@ComponentScan("com.TraineeManager")
public class TraineeManagerApplication {
	
	

	public static void main(String[] args) {
		ApplicationContext  con = SpringApplication.run(TraineeManagerApplication.class, args);
		TraineeDao tService =  con.getBean("traineeDaoImpl",TraineeDaoImpl.class);
		
		
		final Logger LOGGER = LoggerFactory.getLogger(TraineeManagerApplication.class);
		LOGGER.info("In TRainee Managemnet System");
		
		LOGGER.info("Choose the operation");
		LOGGER.info("1. Register trainee: add a new trainee to the repository\n"
				+ "\n"
				+ "2. Remove trainee: remove an existing trainee from the repository\n"
				+ "\n"
				+ "3. Find by name: find if a trainee is present under the cohort\n"
				+ "\n"
				+ "4. Find all: find all trainees in a cohort"
				+ "\n"
				+ "\n"
				+ "5. Add a Trainne to cohort"
				+ "\n"
				+"6. Exit");
//	 try {
//		tService.addTrainee();
//	} catch (InvalidTraineeDataException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//		 tService.findByNameInCohort();
//		 tService.getAllTraineefromCohort();
	
		 
	Scanner sc = new Scanner(System.in);
	
	do {
		LOGGER.info("Enter Choice");
		int ch= sc.nextInt();
		 if(ch==1) {
			 try {
					LOGGER.info(tService.addTrainee());
				} catch (InvalidTraineeDataException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 continue;
			 
		 }
		 else if(ch==2) {
		LOGGER.info( tService.removeTrainee());
		continue;
		 }
		 else if(ch==4) {
			 tService.getAllTraineefromCohort();
			LOGGER.info( "THe list found");
			continue;
			 
		 }
		 
		 else if(ch==3) {
			 LOGGER.info(tService.findByNameInCohort());
			 continue;
			 
		 }
		 else if(ch==5) {
			 try {
			 tService.addTraineeToCohort(); 
			 LOGGER.info("Trainne added");
			 }
			 catch(Exception e) {
				 LOGGER.error("Cannot added in more than one cohort");
			 }
		 }
		 else {
			 LOGGER.info("exit");
			 break;
		 }
	}while(true);
		
		
	}

}
