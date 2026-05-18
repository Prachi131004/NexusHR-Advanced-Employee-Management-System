package com.nexushr.NexusHr.service;

import java.util.List;

import com.nexushr.NexusHr.dto.LeaveRequestDTO;
import com.nexushr.NexusHr.dto.LeaveResponseDTO;
import com.nexushr.NexusHr.enums.LeaveStatus;

public interface LeaveRequestService {

	 // APPLY LEAVE
    LeaveResponseDTO applyForLeave(LeaveRequestDTO dto);

    // APPROVE / REJECT LEAVE
    LeaveResponseDTO updateLeaveStatus(Long leaveId, LeaveStatus status);

    // LEAVE BALANCE
    int getRemainingLeaveBalance(Long employeeId);

    // LEAVE HISTORY
    List<LeaveResponseDTO> getEmployeeLeaveHistory(Long employeeId);
}
