package com.Payroll.service;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Payroll.Repository.DepartmentRepository;
import com.Payroll.Repository.EmployeeRepository;
import com.Payroll.model.Department;
import com.Payroll.model.Employee;

@Service
public class DepartmentSerivce {
	@Autowired
	private DepartmentRepository departmentRepository;
	private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentSerivce.class);
	
	@Transactional
	public Department get(int id) {

	LOGGER.info("Start");

	return departmentRepository.findById(id).get();

	}

}
