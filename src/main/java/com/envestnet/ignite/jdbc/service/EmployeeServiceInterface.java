package com.envestnet.ignite.jdbc.service;

import java.util.List;

import com.envestnet.ignite.jdbc.model.Employee;

public interface EmployeeServiceInterface {


	void addEmployee(Employee employee);
	
	Employee searchEmployeeById(int id);
	
	Employee searchEmployeeByDeptName(String name);
	
	List<Employee> listEmployees();
}
