package com.envestnet.ignite.jdbc.dao;

import java.util.List;

import com.envestnet.ignite.jdbc.model.Employee;

public interface EmployeeDaoInterface {
	void add(Employee employee);
	
	Employee searchById(int id);
	

	Employee searchByDeptName(String name);
	
	List<Employee> getAll();
}
