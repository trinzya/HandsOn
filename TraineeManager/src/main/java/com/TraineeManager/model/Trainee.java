package com.TraineeManager.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Trainee {
	@Id
	private int empId;
	private String name;
	private Date dateOfJoining;
	private String email;
	

	public Trainee(int empId, String traineeName, Date dateOfJoining, String email) {
		super();
		this.empId = empId;
		name = traineeName;
		this.dateOfJoining = dateOfJoining;
	
	}

	public Trainee() {
		// TODO Auto-generated constructor stub
		
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getTraineeName() {
		return name;
	}

	public void setTraineeName(String traineeName) {
		name = traineeName;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	@Override
	public String toString() {
		return "Trainee [empId=" + empId + ", TraineeName=" + name + ", dateOfJoining=" + dateOfJoining
				+ ", email=" + email + " ]";
	}
	
	

}
