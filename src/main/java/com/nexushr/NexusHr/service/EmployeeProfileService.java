package com.nexushr.NexusHr.service;

import com.nexushr.NexusHr.dto.EmployeeProfileRequestDTO;
import com.nexushr.NexusHr.dto.EmployeeProfileResponseDTO;

public interface EmployeeProfileService {
	
	EmployeeProfileResponseDTO createProfile(EmployeeProfileRequestDTO dto);

	EmployeeProfileResponseDTO getProfileByEmployeeId(Long employeeId);

	EmployeeProfileResponseDTO updateProfile(Long employeeId, EmployeeProfileRequestDTO dto);

	void deleteProfile(Long employeeId);

}
