package com.Payroll.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Payroll.model.Department;
@Repository
public interface DepartmentRepository extends  JpaRepository<Department,Integer>{

}
