package com.nexushr.NexusHr.dto;

import java.time.LocalDate;

import com.nexushr.NexusHr.enums.ProjectStatus;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ProjectRequestDTO {
	
	 @NotBlank(message = "Project name is required")
	    @Size(min = 2, max = 100, message = "Project name must be 2 to 100 characters")
	    private String projectName;

	    @NotBlank(message = "Client name is required")
	    @Size(min = 2, max = 100, message = "Client name must be 2 to 100 characters")
	    private String clientName;
	    
	    @NotBlank(message = "Description is required")
	    @Size(min = 5, max = 500, message = "Description must be 5 to 500 characters")
	    private String description;

	    @NotNull(message = "Start date is required")
	    private LocalDate startDate;

	    @NotNull(message = "End date is required")
	    @FutureOrPresent(message = "End date cannot be in past")
	    private LocalDate endDate;
	    
	    @NotNull(message = "Active flag is required")
	    private Boolean active;
	    
	    @NotNull(message = "Status is required")
		private ProjectStatus status;

		public ProjectRequestDTO() {
			super();
	
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
		
		
}
