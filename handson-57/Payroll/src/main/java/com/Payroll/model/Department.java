package com.Payroll.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Department {
	@Id
	private int id;
@Column(name="dp_name")
 private String name;

@OneToMany(mappedBy = "department", fetch = FetchType.EAGER)

private Set<Employee> employeeList;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public Set<Employee> getEmployeeList() {
	return employeeList;
}

public void setEmployeeList(Set<Employee> employeeList) {
	this.employeeList = employeeList;
}

@Override
public String toString() {
	return "Department [id=" + id + ", name=" + name + ", employeeList=" + employeeList + "]";
}

public Department(int id, String name) {
	super();
	this.id = id;
	this.name = name;
}

public Department() {
	super();
	// TODO Auto-generated constructor stub
}



}
