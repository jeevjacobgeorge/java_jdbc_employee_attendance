package com.envestnet.ignite.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.envestnet.ignite.jdbc.model.Employee;


public class EmployeeDao implements EmployeeDaoInterface {
//	private final Employee prototype = new Employee();
	private Connection conn;
	public EmployeeDao(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void add(Employee employee) {
		String query = "INSERT INTO Employee(NAME, EMAIL, PHONE, DEPT_ID) VALUES(?,?,?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, employee.getName());
			pstmt.setString(2, employee.getEmail());
            pstmt.setString(3, employee.getPhone());
            pstmt.setInt(4, employee.getDept_id());
            pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Employee searchById(int id) {
		String query = "SELECT * FROM Employee WHERE id=?";
		try (PreparedStatement pstmt = conn.prepareStatement(query)) {
			pstmt.setInt(1, id);
			ResultSet res = pstmt.executeQuery();
			if(res.next())
				return mapRow(res);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public Employee searchByDeptName(String name) {
	    String query = "SELECT e.* FROM Employee e " +
	                   "INNER JOIN Department d ON e.dept_id = d.id " +
	                   "WHERE d.dept_name = ?";
	    try (PreparedStatement pstmt = conn.prepareStatement(query)) {
	        pstmt.setString(1, name);
	        ResultSet res = pstmt.executeQuery();
	        if (res.next()) {
	            return new Employee(
	                res.getInt(1),     // id
	                res.getString(2),  // name
	                res.getString(3),  // email
	                res.getString(4),  // phone
	                res.getInt(5)      // dept_id
	            );
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return null;
	}

	@Override
	public List<Employee> getAll() {
		List<Employee> ans = new ArrayList<>();
		String query = "Select * from Employee";
		try (PreparedStatement pstmt = conn.prepareStatement(query)){
			ResultSet res = pstmt.executeQuery();
			while(res.next()) {
				ans.add(mapRow(res));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ans;
	}
	private Employee mapRow(ResultSet res) throws SQLException {
		Employee emp = new Employee(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getInt(5));
		return emp;
	}

//	private Employee mapRow(ResultSet res) throws SQLException {
//	    Employee emp = prototype.clone();
//	    emp.setId(res.getInt(1));
//	    emp.setName(res.getString(2));
//	    emp.setEmail(res.getString(3));
//	    emp.setPhone(res.getString(4));
//	    emp.setDept_id(res.getInt(5));
//	    return emp;
//	}
	

}
