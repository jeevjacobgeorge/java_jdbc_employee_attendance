package com.envestnet.ignite.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import com.envestnet.ignite.jdbc.dao.EmployeeDao;
import com.envestnet.ignite.jdbc.dao.EmployeeDaoInterface;
import com.envestnet.ignite.jdbc.model.Employee;
import com.envestnet.ignite.jdbc.service.EmployeeService;
import com.envestnet.ignite.jdbc.service.EmployeeServiceInterface;

public class EmployeeMainApp {

	public static void main(String[] args) {


		String url = "jdbc:h2:file:C:/h2-db/learn";
        String user = "sa";
        String password = "";
        
        try (Connection conn = DriverManager.getConnection(url,user,password)){
        		EmployeeDaoInterface dao = new EmployeeDao(conn);
        		EmployeeServiceInterface service = new EmployeeService(dao);
        		// Step 3: Add an employee        		
            Employee emp = new Employee(1, "Alice", "alice@example.com", "1234567890", 101);
            service.addEmployee(emp);
            System.out.println("Employee added.");

            // Step 4: Search by ID
            Employee foundById = service.searchEmployeeById(1);
            System.out.println("Found by ID: " + foundById);

            // Step 5: Search by Department Name
            Employee foundByDept = service.searchEmployeeByDeptName("Accounting");
            System.out.println("Found by Department: " + foundByDept);

            // Step 6: List all employees
            List<Employee> allEmployees = service.listEmployees();
            System.out.println("All Employees:");
            for (Employee e : allEmployees) {
                System.out.println(e);
            }
        	
        }catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
}
