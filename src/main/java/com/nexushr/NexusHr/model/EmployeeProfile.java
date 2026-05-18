package com.nexushr.NexusHr.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class EmployeeProfile extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String pan;
	private String aadhaar;
	private String ssn;
	private String address;
	private String emergencyContact;
	
	@OneToOne
	@JoinColumn(name ="employee_id")
	@JsonBackReference
	private Employee employee;

	public EmployeeProfile() {
		super();
	}

	public EmployeeProfile(String pan, String aadhaar, String ssn, String address, String emergencyContact,
			Employee employee) {
		super();
		this.pan = pan;
		this.aadhaar = aadhaar;
		this.ssn = ssn;
		this.address = address;
		this.emergencyContact = emergencyContact;
		this.employee = employee;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getAadhaar() {
		return aadhaar;
	}

	public void setAadhaar(String aadhaar) {
		this.aadhaar = aadhaar;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmergencyContact() {
		return emergencyContact;
	}

	public void setEmergencyContact(String emergencyContact) {
		this.emergencyContact = emergencyContact;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "EmployeeProfile [id=" + id + ", pan=" + pan + ", aadhaar=" + aadhaar + ", ssn=" + ssn + ", address="
				+ address + ", emergencyContact=" + emergencyContact + "]";
	}

}
