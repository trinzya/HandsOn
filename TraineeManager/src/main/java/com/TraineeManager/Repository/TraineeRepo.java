package com.TraineeManager.Repository;

import java.util.List;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TraineeManager.model.Trainee;

@Repository
public interface TraineeRepo extends JpaRepository <Trainee,Integer>{

public List<Trainee>  findByName(String traineeName);

}
