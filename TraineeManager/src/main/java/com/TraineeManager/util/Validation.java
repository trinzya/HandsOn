package com.TraineeManager.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation { 
	
	
	public  static boolean validEmail(String email) {
		String regex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		
		Matcher matcher = pattern.matcher(email);
		boolean e = matcher.matches();
		return e;
	}

	public static  boolean validCohort_code(String code) {
	return Pattern.matches("[A-Z]{3}[0-9]{2}[A-Z]{2}[0-9]{2}",code);
	}  
	
	public static boolean validEmpId(int id) { 
	String s=	Integer.toString(id);
	return (s.length()==6);
		
	}

}
