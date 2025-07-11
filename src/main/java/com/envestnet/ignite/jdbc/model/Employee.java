package com.envestnet.ignite.jdbc.model;


public class Employee {
	private int id;
	private String name;
	private String email,phone;
	private int dept_id;
	public Employee(int id,String name, String email, String phone, int dept_id) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.dept_id = dept_id;
	}
	public Employee(String name, String email, String phone, int dept_id) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.dept_id = dept_id;
	}
	public Employee(Employee other) {
		this.id = other.getId();
		this.name = other.getName();
		this.email = other.getEmail();
		this.phone = other.getPhone();
		this.dept_id = other.getDept_id();
	}
	public Employee() {
		// TODO Auto-generated constructor stub
	}
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getDept_id() {
		return dept_id;
	}
	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", dept_id=" + dept_id
				+ "]";
	}
}
