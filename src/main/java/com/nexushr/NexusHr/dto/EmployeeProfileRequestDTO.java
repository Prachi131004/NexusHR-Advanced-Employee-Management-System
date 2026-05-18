package com.nexushr.NexusHr.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class EmployeeProfileRequestDTO {
	
	@NotBlank(message="Pan is required")
	 @Pattern(
		        regexp = "^[A-Z]{5}[0-9]{4}[A-Z]{1}$",
		        message = "Invalid PAN format (e.g. ABCDE1234F)"
		    )
	private String pan;
	
	@NotBlank(message = "Aadhaar is required")
    @Pattern(
        regexp = "^[2-9]{1}[0-9]{11}$",
        message = "Aadhaar must be exactly 12 digits"
    )
	private String aadhaar;
	
	@NotBlank
	@Pattern(
			regexp = "^\\d{3}-\\d{2}-\\d{4}$",
			message = "SSN must be in format XXX-XX-XXXX"
			)
	private String ssn;
	
	@NotBlank(message = "Address is required")
    @Size(min = 10, max = 200, message = "Address must be between 10 to 200 characters")
	private String address;
	
	 @NotBlank(message = "Emergency contact is required")
	    @Pattern(
	        regexp = "\\d{10}",
	        message = "Emergency contact must be 10 digit number"
	    )
	private String emergencyContact;
	 
	private Long employeeId;

	public EmployeeProfileRequestDTO() {
		super();
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

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

}
