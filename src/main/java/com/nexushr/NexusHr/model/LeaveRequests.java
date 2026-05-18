 package com.nexushr.NexusHr.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.nexushr.NexusHr.enums.LeaveStatus;
import com.nexushr.NexusHr.enums.LeaveType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class LeaveRequests extends BaseEntity{
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private LeaveType leaveType;
	private LocalDate startDate;
	private LocalDate endDate;
	private String reason;
	
	@Enumerated(EnumType.STRING)
	private LeaveStatus status = LeaveStatus.PENDING; 
	
	@ManyToOne
	@JoinColumn(name ="employee_id")
	@JsonBackReference
	private Employee employee;

	public LeaveRequests() {
		super();
	}

	public LeaveRequests(LeaveType leaveType, LocalDate startDate, LocalDate endDate, String reason, LeaveStatus status,
			Employee employee) {
		super();
		this.leaveType = leaveType;
		this.startDate = startDate;
		this.endDate = endDate;
		this.reason = reason;
		this.status = status;
		this.employee = employee;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LeaveType getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(LeaveType leaveType) {
		this.leaveType = leaveType;
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

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public LeaveStatus getStatus() {
		return status;
	}

	public void setStatus(LeaveStatus status) {
		this.status = status;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "LeaveRequests [id=" + id + ", leaveType=" + leaveType + ", startDate=" + startDate + ", endDate="
				+ endDate + ", reason=" + reason + ", status=" + status + "]";
	}
}
