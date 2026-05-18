package com.nexushr.NexusHr.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nexushr.NexusHr.dto.DepartmentRequestDTO;
import com.nexushr.NexusHr.dto.DepartmentResponseDTO;

import com.nexushr.NexusHr.enums.DepartmentName;

public interface DepartmentService {
	
	DepartmentResponseDTO createDepartment(DepartmentRequestDTO dto);

    Page<DepartmentResponseDTO> getAllDepartments(Pageable pageable);

    DepartmentResponseDTO getDepartmentById(Long id);

    DepartmentResponseDTO updateDepartment(Long id, DepartmentRequestDTO dto);

    void deleteDepartment(Long id);

    void raiseSalaryForDepartment(Long departmentId, double percentage);

    DepartmentResponseDTO getDepartmentStats(Long id);
    
    Page<DepartmentResponseDTO> searchDepartments(
            DepartmentName departmentName,
            String location,
            Pageable pageable);

}
