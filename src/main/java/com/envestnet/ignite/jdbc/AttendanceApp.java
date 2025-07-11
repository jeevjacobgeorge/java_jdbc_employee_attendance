package com.envestnet.ignite.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.envestnet.ignite.jdbc.dao.AttendanceDao;
import com.envestnet.ignite.jdbc.service.AttendanceService;

public class AttendanceApp {
	

	public static void main(String[] args) {

		String url = "jdbc:h2:file:C:/h2-db/learn";
        String user = "sa";
        String password = "";
        
        try(Connection conn = DriverManager.getConnection(url,user,password)){
        		AttendanceDao dao = new AttendanceDao(conn);
        		AttendanceService service = new AttendanceService(dao);
        		service.getEmployeesPresentOnDate("2025-07-10").forEach(System.out::println);;
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
