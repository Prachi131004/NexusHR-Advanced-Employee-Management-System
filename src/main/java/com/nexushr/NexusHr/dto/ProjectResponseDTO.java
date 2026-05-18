package com.nexushr.NexusHr.dto;

import java.time.LocalDate;
import java.util.Set;

import com.nexushr.NexusHr.enums.ProjectStatus;


public class ProjectResponseDTO {
	
	    private Long id;
	    private String projectName;
	    private String clientName;
	    private String description;
	    private LocalDate startDate;
	    private LocalDate endDate;
	    private Boolean active;
	    private ProjectStatus status;

	    private int totalMembers;
	    private Set<String> employeeNames;
	    
		public ProjectResponseDTO() {
			super();
			
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getProjectName() {
			return projectName;
		}

		public void setProjectName(String projectName) {
			this.projectName = projectName;
		}

		public String getClientName() {
			return clientName;
		}

		public void setClientName(String clientName) {
			this.clientName = clientName;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
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

		public int getTotalMembers() {
			return totalMembers;
		}

		public void setTotalMembers(int totalMembers) {
			this.totalMembers = totalMembers;
		}

		public Set<String> getEmployeeNames() {
			return employeeNames;
		}

		public void setEmployeeNames(Set<String> employeeNames) {
			this.employeeNames = employeeNames;
		}
	    
}
