package com.nexushr.NexusHr.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nexushr.NexusHr.dto.LeaveRequestDTO;
import com.nexushr.NexusHr.dto.LeaveResponseDTO;
import com.nexushr.NexusHr.enums.LeaveStatus;
import com.nexushr.NexusHr.service.LeaveRequestService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/leaves")
public class LeaveRequestController {
	
	 private final LeaveRequestService leaveRequestService;

	    public LeaveRequestController(
	            LeaveRequestService leaveRequestService) {
	        this.leaveRequestService = leaveRequestService;
	    }

	    // APPLY FOR LEAVE 
	    // POST /api/v1/leaves/request
	    @PostMapping("/request")
	    public LeaveResponseDTO applyForLeave(
	            @Valid @RequestBody LeaveRequestDTO dto) {

	        return leaveRequestService.applyForLeave(dto);
	    }

	    // APPROVE / REJECT LEAVE 
	    // PUT /api/v1/leaves/{id}/status?status=APPROVED
	    @PutMapping("/{id}/status")
	    public LeaveResponseDTO updateLeaveStatus(
	            @PathVariable Long id,
	            @RequestParam LeaveStatus status) {

	        return leaveRequestService
	                .updateLeaveStatus(id, status);
	    }

	    // VIEW LEAVE BALANCE 
	    // GET /api/v1/leaves/employees/{employeeId}/balance
	    @GetMapping("/employees/{employeeId}/balance")
	    public int getRemainingLeaveBalance(
	            @PathVariable Long employeeId) {

	        return leaveRequestService
	                .getRemainingLeaveBalance(employeeId);
	    }

	    //LEAVE HISTORY 
	    // GET /api/v1/leaves/employees/{employeeId}/history
	    @GetMapping("/employees/{employeeId}/history")
	    public List<LeaveResponseDTO> getEmployeeLeaveHistory(
	            @PathVariable Long employeeId) {

	        return leaveRequestService
	                .getEmployeeLeaveHistory(employeeId);
	    }
	
	

}
