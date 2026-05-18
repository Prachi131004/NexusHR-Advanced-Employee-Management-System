package com.nexushr.NexusHr.dto;

import com.nexushr.NexusHr.enums.DepartmentName;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class DepartmentRequestDTO {
	
	@NotNull(message="Department name is required")
	private DepartmentName departmentName;
	
	@Min(value = 0, message = "Budget cannot be negative")
	private double budget;
	
	@NotBlank(message = "Location is required")
	@Size(min = 2, max = 100, message = "Location must be valid")
	private String location;
	
	 @NotBlank(message = "Department head is required")
	 @Pattern(regexp = "^[A-Za-z ]+$", message = "Only letters allowed in department head name")
	private String departmentHead;
	 
	public DepartmentRequestDTO() {
		super();
	
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

	 
}
