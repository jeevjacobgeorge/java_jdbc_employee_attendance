package com.envestnet.ignite.jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcDemo {
//	final static String URL = "jdbc:h2:file:C:/h2-db/learn";
//	final static String USERNAME="sa";
//	final static String PASSWORD="";
	final static String JDBC_DRIVER="org.h2.Driver";
	public static void main(String[] args) {
		Properties props = new Properties();
		try (FileInputStream fis = new FileInputStream("src/main/resources/db.properties")) {
            props.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
		String url = props.getProperty("db.url");
        String user = props.getProperty("db.username");
        String password = props.getProperty("db.password");
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try (Connection conn = DriverManager.getConnection(url,user,password);){
			System.out.println("Connected to Database");
			Statement stmt = conn.createStatement();
//			String createQuery = "CREATE TABLE STUDENT(id INT PRIMARY KEY,name VARCHAR(255));";
//		 	stmt.execute(createQuery);
			String query = "SELECT * FROM STUDENT;";
		 	ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				System.out.println("Id:"+rs.getInt(1)+" Name"+rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
