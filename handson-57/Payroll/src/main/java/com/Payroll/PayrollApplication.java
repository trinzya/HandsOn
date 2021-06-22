package com.Payroll;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.Payroll.model.Department;
import com.Payroll.model.Employee;
import com.Payroll.model.Skill;
import com.Payroll.service.DepartmentSerivce;
import com.Payroll.service.EmployeeService;
import com.Payroll.service.SkillService;


@SpringBootApplication
public class PayrollApplication {
	
	private static EmployeeService employeeService;
	private static DepartmentSerivce departmentService;
	private static SkillService skillService;
	private static final Logger LOGGER = LoggerFactory.getLogger(PayrollApplication.class);
	private static void testGetEmployee() {

		LOGGER.info("Start");

		Employee employee = employeeService.get(1);

		LOGGER.debug("Employee:{}", employee);

		LOGGER.debug("Department:{}", employee.getDepartment());
		LOGGER.debug("Skills:{}", employee.getSkillList());
		LOGGER.info("Skills:{}", employee.getSkillList());
		LOGGER.info("End");

		}
	public static void testAddSkillToEmployee() {
	Employee e=	employeeService.get(1);
	Skill s= skillService.get(2);
Set f=	e.getSkillList();
f.add(s);
employeeService.save(e);
LOGGER.info("End");

	}
	
	private static void addEmployee() {
		LOGGER.info("Start");
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		 Date birth = null;
		try {
			birth = sdf.parse("1999-02-27");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Employee e = new Employee (1,"Trinzya",9000,true,birth);
employeeService.save(e);
LOGGER.info("Employee saved");
LOGGER.info("End");

	} 
	
	private static void updateEmployee() {
	Department d =	departmentService.get(1);
	Employee e=	employeeService.get(1);
	e.setDepartment(d);
employeeService.save(e);
LOGGER.info("Employee saved");
LOGGER.info("End");

	}  
	
	private static void	testGetDepartment() {
		Department d =	departmentService.get(1);
		LOGGER.info("d",d);
		LOGGER.info("list {}",d.getEmployeeList());
		LOGGER.info("End");
	}
	public static void testGetAllPermanentEmployees() {

		LOGGER.info("Start");

		List<Employee> employees = employeeService.getAllPermanentEmployees();

		LOGGER.info("Permanent Employees:{}", employees);

		employees.forEach(e -> LOGGER.debug("Skills:{}", e.getSkillList()));

		LOGGER.info("End");

		}
	
	public static void testgetAverageSalary() {
		double avg_salary = employeeService.getAverageSalary(1);
		LOGGER.info("Permanent Employees:{}", avg_salary);
		LOGGER.info("End");
	}
	
	public static void testgetAllEmployeesNative() {
		List<Employee> e =employeeService.getAllEmployeesNative();
		LOGGER.info(" Employees:{}", e);
		LOGGER.info("End");
	}

	public static void main(String[] args) {
//		SpringApplication.run(PayrollApplication.class, args);
		ApplicationContext context = SpringApplication.run(PayrollApplication.class, args);
		LOGGER.info("hello");
		employeeService = context.getBean(EmployeeService.class);
		departmentService = context.getBean(DepartmentSerivce.class);
		skillService = context.getBean(SkillService.class);
	
//	testGetEmployee();
//		addEmployee();
		
//		updateEmployee();
//	
//		testGetDepartment();
//	testAddSkillToEmployee();
//		testGetAllPermanentEmployees();
//		testgetAverageSalary();
//		testgetAllEmployeesNative();
	}
}

