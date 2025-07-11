package com.envestnet.ignite.jdbc.service;

import java.util.List;

import com.envestnet.ignite.jdbc.dao.EmployeeDaoInterface;
import com.envestnet.ignite.jdbc.model.Employee;

public class EmployeeService implements EmployeeServiceInterface {
	private EmployeeDaoInterface dao;
	
	public EmployeeService(EmployeeDaoInterface dao) {
		this.dao = dao;
	}

	@Override
	public void addEmployee(Employee employee) {
		dao.add(employee);

	}

	@Override
	public Employee searchEmployeeById(int id) {
		return dao.searchById(id);
	}

	@Override
	public Employee searchEmployeeByDeptName(String name) {
		return dao.searchByDeptName(name);
	}

	@Override
	public List<Employee> listEmployees() {
		return dao.getAll();
	}

}
