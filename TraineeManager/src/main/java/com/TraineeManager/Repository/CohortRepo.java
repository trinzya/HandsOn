package com.TraineeManager.Repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TraineeManager.model.Cohort;
@Repository
public interface CohortRepo  extends JpaRepository<Cohort, String> {

	

	
	
	

}
