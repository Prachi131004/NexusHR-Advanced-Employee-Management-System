package com.nexushr.NexusHr.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.nexushr.NexusHr.enums.DepartmentName;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Department extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Enumerated(EnumType.STRING)
	private DepartmentName departmentName;
	private double budget;
	private String location;
	private String departmentHead;
	
	private Boolean active = true;
	 
	
	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonManagedReference
	private List<Employee> employees;

	public Department() {
		super();
	}

	public Department(DepartmentName departmentName, double budget, String location, String departmentHead, boolean active,
			List<Employee> employee) {
		super();
		this.departmentName = departmentName;
		this.budget = budget;
		this.location = location;
		this.departmentHead = departmentHead;
		this.active = active;
		this.employees = employee;
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

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees  = employees;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", departmentName=" + departmentName + ", budget=" + budget + ", location="
				+ location + ", departmentHead=" + departmentHead + ", active=" + active + "]";
	}

	
 
}
