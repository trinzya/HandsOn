package com.Payroll.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Payroll.model.Skill;
@Repository
public interface SkillRepository extends  JpaRepository<Skill,Integer>{

}
