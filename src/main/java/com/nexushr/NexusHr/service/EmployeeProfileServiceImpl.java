package com.nexushr.NexusHr.service;

import org.springframework.stereotype.Service;

import com.nexushr.NexusHr.dto.EmployeeProfileRequestDTO;
import com.nexushr.NexusHr.dto.EmployeeProfileResponseDTO;
import com.nexushr.NexusHr.mapper.EmployeeProfileMapper;
import com.nexushr.NexusHr.model.Employee;
import com.nexushr.NexusHr.model.EmployeeProfile;
import com.nexushr.NexusHr.repository.EmployeeProfileRepository;
import com.nexushr.NexusHr.repository.EmployeeRepository;

@Service
public class EmployeeProfileServiceImpl implements EmployeeProfileService {
	
	private final EmployeeProfileRepository employeeProfileRepository;

	private final EmployeeRepository employeeRepository;

	private final EmployeeProfileMapper employeeProfileMapper;

	public EmployeeProfileServiceImpl(EmployeeProfileRepository employeeProfileRepository,

			EmployeeRepository employeeRepository,

			EmployeeProfileMapper employeeProfileMapper) {

		this.employeeProfileRepository = employeeProfileRepository;

		this.employeeRepository = employeeRepository;

		this.employeeProfileMapper = employeeProfileMapper;
	}

	//CREATE
	
	@Override
	public EmployeeProfileResponseDTO createProfile(EmployeeProfileRequestDTO dto) {
		Employee employee = employeeRepository.findById(dto.getEmployeeId())
				.orElseThrow(() -> new RuntimeException("Employee not found"));

		EmployeeProfile profile = employeeProfileMapper.toEntity(dto);

		profile.setId(null);      // IMPORTANT
		profile.setEmployee(employee);

		EmployeeProfile saved = employeeProfileRepository.save(profile);

		return employeeProfileMapper.toResponseDTO(saved);
	}
	
	//GET

	@Override
	public EmployeeProfileResponseDTO getProfileByEmployeeId(Long employeeId) {
		EmployeeProfile profile = employeeProfileRepository.findByEmployee_Id(employeeId)
				.orElseThrow(() -> new RuntimeException("Profile not found"));

		return employeeProfileMapper.toResponseDTO(profile);
	}

	//UPDATE
	
	@Override
	public EmployeeProfileResponseDTO updateProfile(Long employeeId, EmployeeProfileRequestDTO dto) {
		EmployeeProfile profile = employeeProfileRepository.findByEmployee_Id(employeeId)
				.orElseThrow(() -> new RuntimeException("Profile not found"));

		employeeProfileMapper.updateEntity(dto, profile);

		EmployeeProfile updated = employeeProfileRepository.save(profile);

		return employeeProfileMapper.toResponseDTO(updated);
	}
    
	//DELETE
	
	@Override
	public void deleteProfile(Long employeeId) {
		EmployeeProfile profile = employeeProfileRepository.findByEmployee_Id(employeeId)
				.orElseThrow(() -> new RuntimeException("Profile not found"));

		employeeProfileRepository.delete(profile);
	}

}
