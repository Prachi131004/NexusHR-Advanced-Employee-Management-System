package com.nexushr.NexusHr.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.nexushr.NexusHr.enums.ProjectStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Project extends BaseEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String clientName;
	private LocalDate startDate;
	private LocalDate endDate;
	private String projectName;
	private String description;
	private Boolean active = true;
	private ProjectStatus status;
	
	
	@ManyToMany(mappedBy = "projects")
	@JsonBackReference
	private Set<Employee> employees = new HashSet<>();

	public Project() {
		super();
	}

	public Project(String clientName, LocalDate startDate, LocalDate endDate, String projectName, String description, Boolean active, ProjectStatus status,
			Set<Employee> employee) {
		super();
		this.clientName = clientName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.description = description;
		this.active = active;
		this.status = status;
		this.projectName = projectName;
		this.employees = employee;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}


	public ProjectStatus getStatus() {
		return status;
	}

	public void setStatus(ProjectStatus status) {
		this.status = status;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", clientName=" + clientName + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", projectName=" + projectName + ", description =" + description + ", active =" + active + ", status ="+ status +"]";
	}
	
}
