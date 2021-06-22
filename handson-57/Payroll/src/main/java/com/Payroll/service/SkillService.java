package com.Payroll.service;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Payroll.Repository.DepartmentRepository;
import com.Payroll.Repository.SkillRepository;
import com.Payroll.model.Department;
import com.Payroll.model.Skill;
@Service
public class SkillService {


	
		@Autowired
		private SkillRepository skillRepository;
		private final Logger LOGGER = LoggerFactory.getLogger(SkillService.class);
		
		@Transactional
		public Skill get(int id) {

		LOGGER.info("Start");

		return skillRepository.findById(id).get();

		}
	}



