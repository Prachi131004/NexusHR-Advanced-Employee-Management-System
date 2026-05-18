package com.nexushr.NexusHr.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.nexushr.NexusHr.enums.EmployeeStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Employee  extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String gender;
	private String mobileNumber;
	private String dateOfBirth;
	private double salary;
	private String designation;
	private LocalDate joiningDate;
	private Boolean active = true;
	private LocalDate exitDate;

    @Enumerated(EnumType.STRING)
	private EmployeeStatus status; // ACTIVE, RESIGNED, TERMINATED
	
	@OneToOne(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonManagedReference
	private EmployeeProfile employeeProfile;
	
	@ManyToOne
	@JoinColumn(name = "department_id")
	@JsonBackReference
	private Department department;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
	@JoinTable(
			name="employee_project",
			joinColumns = @JoinColumn(name="employee_id"),
			inverseJoinColumns = @JoinColumn(name = "project_id")
			)
	@JsonManagedReference
	private Set<Project> projects = new HashSet<>();
	
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonManagedReference
	private List<LeaveRequests> leaveRequests;

	public Employee() {
		super();
	}

	public Employee(String firstName, String lastName, String email, String password, String mobileNumber, String dateOfBirth, String gender, double salary, String designation,
			LocalDate joiningdate, Boolean active, LocalDate exitDate, EmployeeStatus status, EmployeeProfile employeeprofile, Department department, Set<Project> project,
			List<LeaveRequests> leaveRequests) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.mobileNumber = mobileNumber;
		this.dateOfBirth = dateOfBirth;
		this.salary = salary;
		this.designation = designation;
		this.joiningDate = joiningdate;
		this.active = active;
		this.exitDate = exitDate;
		this.status = status;
		this.employeeProfile = employeeprofile;
		this.department = department;
		this.projects = project;
		this.leaveRequests = leaveRequests;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public  double getSalary() {
		return salary;
	}

	public void setSalary( double salary) {
		this.salary = salary;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public void setStatus(EmployeeStatus string) {
		this.status = string;
	}

	public EmployeeProfile getEmployeeProfile() {
		return employeeProfile;
	}

	public void setEmployeeProfile(EmployeeProfile employeeProfile) {
		this.employeeProfile = employeeProfile;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Set<Project> getProjects() {
		return projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}

	public List<LeaveRequests> getLeaveRequests() {
		return leaveRequests;
	}

	public void setLeaveRequests(List<LeaveRequests> leaveRequests) {
		this.leaveRequests = leaveRequests;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", gender=" + gender + ", mobileNumber=" + mobileNumber
				+ ", dateOfBirth=" + dateOfBirth + ", salary=" + salary + ", designation=" + designation
				+ ", joiningDate=" + joiningDate + ", active=" + active + ", exitDate=" + exitDate + ", status="
				+ status + ", employeeProfile=" + employeeProfile + ", department=" + department + ", projects="
				+ projects + ", leaveRequests=" + leaveRequests + "]";
	}

}
