package com.nexushr.NexusHr.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.nexushr.NexusHr.dto.LeaveRequestDTO;
import com.nexushr.NexusHr.dto.LeaveResponseDTO;
import com.nexushr.NexusHr.enums.LeaveStatus;
import com.nexushr.NexusHr.mapper.LeaveRequestMapper;
import com.nexushr.NexusHr.model.Employee;
import com.nexushr.NexusHr.model.LeaveRequests;
import com.nexushr.NexusHr.repository.EmployeeRepository;
import com.nexushr.NexusHr.repository.LeaveRequestsRepository;

@Service
public class LeaveRequestServiceImpl implements LeaveRequestService {
	
	private final LeaveRequestsRepository leaveRepo;
    private final EmployeeRepository employeeRepo;
    private final LeaveRequestMapper mapper;

	public LeaveRequestServiceImpl(LeaveRequestsRepository leaveRepo, EmployeeRepository employeeRepo,
			LeaveRequestMapper mapper) {

		this.leaveRepo = leaveRepo;
		this.employeeRepo = employeeRepo;
		this.mapper = mapper;
	}
	
	//APPLY FOR LEAVE
	@Override
	public LeaveResponseDTO applyForLeave(LeaveRequestDTO dto) {
		 Employee employee = employeeRepo.findById(dto.getEmployeeId())
	                .orElseThrow(() -> new RuntimeException("Employee not found"));

	        LeaveRequests leave = mapper.toEntity(dto);
	        leave.setId(null);   

	        leave.setEmployee(employee);
	        leave.setStatus(LeaveStatus.PENDING);

	        LeaveRequests saved = leaveRepo.save(leave);

	        return mapper.toResponseDTO(saved);
	}
	
	//UPDATE
	@Override
	public LeaveResponseDTO updateLeaveStatus(Long leaveId, LeaveStatus status) {
		
		 LeaveRequests leave = leaveRepo.findById(leaveId)
	                .orElseThrow(() -> new RuntimeException("Leave not found"));

	        leave.setStatus(status);

	        LeaveRequests updated = leaveRepo.save(leave);

	        return mapper.toResponseDTO(updated);
	}

	//VIEW LEAVE BALANCE
	@Override
	public int getRemainingLeaveBalance(Long employeeId) {
		
		//check if employee exists
	    employeeRepo.findById(employeeId)
	            .orElseThrow(() ->
	                    new RuntimeException("Employee not found"));

	    int totalAllowedLeaves = 24;

	    int usedLeaves = leaveRepo.findByEmployee_Id(employeeId)
	            .stream()
	            .filter(l -> l.getStatus() == LeaveStatus.APPROVED)
	            .mapToInt(l -> (int)
	                    (l.getEndDate().toEpochDay()
	                    - l.getStartDate().toEpochDay() + 1))
	            .sum();

	    return totalAllowedLeaves - usedLeaves;
		
	    }
	
    //VIEW LEAVE HISTORY
	@Override
	public List<LeaveResponseDTO> getEmployeeLeaveHistory(Long employeeId) {
		  return leaveRepo.findByEmployee_Id(employeeId)
	                .stream()
	                .map(mapper::toResponseDTO)
	                .collect(Collectors.toList());
	}

	
}
