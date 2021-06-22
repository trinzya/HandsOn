package com.TraineeManager.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
//This class various validation checks
public class Validation { 
	
	//This function is used to check whether email is valid or not.
	public  static boolean validEmail(String email) {
		String regex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		
		Matcher matcher = pattern.matcher(email);
		boolean e = matcher.matches();
		return e;
	}
	
	//This function is used to check whether cohort code is in the requested format or not.
	public static  boolean validCohort_code(String code) {
	return Pattern.matches("[A-Z]{3}[0-9]{2}[A-Z]{2}[0-9]{2}",code);
	}  
	
	//The fucntion is used to check whether the trainee employee id is of six digits or not
	public static boolean validEmpId(int id) { 
	String s=	Integer.toString(id);
	return (s.length()==6);
		
	}

}
