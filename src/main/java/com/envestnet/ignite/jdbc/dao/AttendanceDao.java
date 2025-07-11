package com.envestnet.ignite.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.envestnet.ignite.jdbc.model.Employee;

public class AttendanceDao {

	Connection conn;
	public AttendanceDao(Connection conn) {
		this.conn=conn;
	}
	
	public List<Employee> getEmployeesPresent(String date) {
		List<Employee> employees = new ArrayList<>();
		String query = " select e.* from attendance a left join employee e on a.employee_id=e.id where a.attendance_date =?";
		try {
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1,date);
			ResultSet res = stmt.executeQuery();
			while(res.next()) {
				employees.add(mapRow(res));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}
	
	private Employee mapRow(ResultSet res) throws SQLException {
		Employee emp = new Employee(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getInt(5));
		return emp;
	}
	
	public static void main(String args[]) {
		String url = "jdbc:h2:file:C:/h2-db/learn";
        String user = "sa";
        String password = "";
        
        try (Connection conn = DriverManager.getConnection(url,user,password)){
			List<Employee> employees = new AttendanceDao(conn).getEmployeesPresent("2025-07-10");
			employees.forEach(System.out::println);
        } catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
