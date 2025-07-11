package com.envestnet.ignite.jdbc.model;

public class Department {

	private int id;
	private String name;
	private int manager_id;
	public Department(int id, String name, int manager_id) {
		super();
		this.id = id;
		this.name = name;
		this.manager_id = manager_id;
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
	public int getManager_id() {
		return manager_id;
	}
	public void setManager_id(int manager_id) {
		this.manager_id = manager_id;
	}
	
	
}
