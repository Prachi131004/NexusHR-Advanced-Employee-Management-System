package com.nexushr.NexusHr.dto;

import java.util.List;

import com.nexushr.NexusHr.enums.DepartmentName;

public class DepartmentResponseDTO {

	private Long id;
	private DepartmentName departmentName;
	private double budget;
	private String location;
	private String departmentHead;
	
	private int totalEmployees;
	private boolean active;
	
	private List<EmployeeResponseDTO> employees;
	

	public DepartmentResponseDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DepartmentName getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(DepartmentName departmentName) {
		this.departmentName = departmentName;
	}

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDepartmentHead() {
		return departmentHead;
	}

	public void setDepartmentHead(String departmentHead) {
		this.departmentHead = departmentHead;
	}

	public int getTotalEmployees() {
		return totalEmployees;
	}

	public void setTotalEmployees(int totalEmployees) {
		this.totalEmployees = totalEmployees;
	}
	
	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<EmployeeResponseDTO> getEmployees() {
		return employees;
	}

	public void setEmployees(List<EmployeeResponseDTO> employees) {
		this.employees = employees;
	}
	
	
}
