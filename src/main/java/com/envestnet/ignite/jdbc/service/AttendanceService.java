package com.envestnet.ignite.jdbc.service;

import java.util.List;

import com.envestnet.ignite.jdbc.dao.AttendanceDao;
import com.envestnet.ignite.jdbc.model.Employee;

public class AttendanceService {
	
	private AttendanceDao dao;
	
	public AttendanceService(AttendanceDao dao) {
		this.dao = dao;
	}
	
	public List<Employee> getEmployeesPresentOnDate(String date) {
		return dao.getEmployeesPresent(date);
	}
	
}
