package com.nexushr.NexusHr.dto;

import java.time.LocalDate;
import java.util.Set;

import com.nexushr.NexusHr.enums.EmployeeStatus;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class EmployeeRequestDTO {
 
	@NotBlank(message = "First name is required")
    @Size(min = 2, max = 30, message = "First name must be 2 to 30 characters")
    @Pattern(regexp = "^[A-Za-z ]+$", message = "First name must contain only letters")
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Size(min = 2, max = 30, message = "Last name must be 2 to 30 characters")
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Last name must contain only letters")
    private String lastName;

    @NotBlank(message = "Email is required")
    @Column(unique = true)
    @Email(message = "Enter valid email")
    @Pattern(
        regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$",
        message = "Enter valid email address"
    )
    private String email;
    
    @NotBlank(message = "Password is required")
    @Size(min = 8, message = "Password must be minimum 8 characters")
    @Pattern(
        regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=!]).*$",
        message = "Password must contain uppercase, lowercase, number and special character"
    )
    private String password;
    
    @NotBlank(message ="Gender is required")
    private String gender;
    
    @NotBlank(message ="MobileNumber is required")
    private String mobileNumber;
    
    @NotBlank(message ="DateOfBirth is required")
    private String dateOfBirth;
    
    @Positive(message = "Salary must be greater than 0")
    private double salary;

    @NotBlank(message = "Designation is required")
    private String designation;

    @NotNull(message = "Joining date is required")
    private LocalDate joiningDate;
    
    @NotNull(message = "Active flag is required")
    private Boolean active;
    
    @NotNull(message = "Status is required")
    private EmployeeStatus status;
    
    @PastOrPresent(message = "Exit date cannot be in future")
    private LocalDate exitDate;

    @NotNull(message = "Department id is required")
    private Long departmentId;
    
    private Set<Long> projectIds;

    public EmployeeRequestDTO() {
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
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

	public LocalDate getExitDate() {
		return exitDate;
	}

	public void setExitDate(LocalDate exitDate) {
		this.exitDate = exitDate;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
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

	public Set<Long> getProjectIds() {
		return projectIds;
	}

	public void setProjectIds(Set<Long> projectIds) {
		this.projectIds = projectIds;
	}
}
