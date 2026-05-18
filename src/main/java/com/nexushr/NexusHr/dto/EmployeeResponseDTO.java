package com.nexushr.NexusHr.dto;

import java.time.LocalDate;
import java.util.Set;

import com.nexushr.NexusHr.enums.EmployeeStatus;

public class EmployeeResponseDTO {
	
	    private Long id;
	    private String firstName;
	    private String lastName;
	    private String email;
	    private String gender;
	    private String mobileNumber;
		private String dateOfBirth;
	    private double salary;
	    private String designation;
	    private LocalDate joiningDate;
	    private Boolean active;
		private LocalDate exitDate;
		private EmployeeStatus status;

	    private Set<String> projectNames;
	    
	    private Long departmentId;
	    
	    private String departmentName;

		public EmployeeResponseDTO() {
			super();
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}
		

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}


		public String getMobileNumber() {
			return mobileNumber;
		}

		public void setMobileNumber(String mobileNumber) {
			this.mobileNumber = mobileNumber;
		}

		public String getDateOfBirth() {
			return dateOfBirth;
		}

		public void setDateOfBirth(String dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}

		public double getSalary() {
			return salary;
		}

		public void setSalary(double salary) {
			this.salary = salary;
		}

		public String getDesignation() {
			return designation;
		}

		public void setDesignation(String designation) {
			this.designation = designation;
		}

		public LocalDate getJoiningDate() {
			return joiningDate;
		}

		public void setJoiningDate(LocalDate joiningDate) {
			this.joiningDate = joiningDate;
		}
		
		public Boolean getActive() {
			return active;
		}

		public void setActive(Boolean active) {
			this.active = active;
		}

		public LocalDate getExitDate() {
			return exitDate;
		}

		public void setExitDate(LocalDate exitDate) {
			this.exitDate = exitDate;
		}

		public EmployeeStatus getStatus() {
			return status;
		}

		public void setStatus(EmployeeStatus status) {
			this.status = status;
		}

		public Long getDepartmentId() {
			return departmentId;
		}

		public void setDepartmentId(Long departmentId) {
			this.departmentId = departmentId;
		}

		public String getDepartmentName() {
			return departmentName;
		}

		public void setDepartmentName(String departmentName) {
			this.departmentName = departmentName;
		}

		public Set<String> getProjectNames() {
			return projectNames;
		}

		public void setProjectNames(Set<String> projectNames) {
			this.projectNames = projectNames;
		}    
		

}
