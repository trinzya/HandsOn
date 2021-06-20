package com.patientintakesystem;

import java.time.LocalDate;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PatientAppointment {

	
	
	private int p_id;
	private String name;
	private Date appoitment;
	private String d;
	

	
}
