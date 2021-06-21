package com.TraineeManager.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Cohort {
	@Id
	private String cohort_code;
	@OneToMany(fetch = FetchType.EAGER)
	private List<Trainee> trainees ;

	public Cohort() {
		// TODO Auto-generated constructor stub
	}

	public String getCohort_code() {
		return this.cohort_code;
	}

	public void setCohort_code(String cohort_code) {
		this.cohort_code = cohort_code;
	}

	public List<Trainee> getTrainees() {
		return this.trainees;
	}

	public void setTrainees(List<Trainee> trainees) {
		this.trainees = trainees;
	}

	

	@Override
	public String toString() {
		return "Cohort [cohort_code=" + cohort_code + ", trainees=" + trainees + "]";
	}

	public Cohort(String cohort_code) {
		
		this.cohort_code = cohort_code;
		
	}
	
	public boolean addTrainee(Trainee t) {
		System.out.println(trainees);
	return	trainees.add(t);
	}
	public boolean removeTrainee(Trainee t) {
		return	trainees.remove(t);
		}
	
	
	

}
