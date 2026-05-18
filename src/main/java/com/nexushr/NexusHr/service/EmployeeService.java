package com.nexushr.NexusHr.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nexushr.NexusHr.dto.EmployeeRequestDTO;
import com.nexushr.NexusHr.dto.EmployeeResponseDTO;

public interface EmployeeService {
       
	EmployeeResponseDTO createEmployee(EmployeeRequestDTO dto);

    EmployeeResponseDTO getEmployeeById(Long id);

    List<EmployeeResponseDTO> getAllEmployees();

    Page<EmployeeResponseDTO> getAllEmployees(Pageable pageable);

    EmployeeResponseDTO updateEmployee(Long id, EmployeeRequestDTO dto);

    void deleteEmployee(Long id);

    EmployeeResponseDTO transferEmployee(Long employeeId, Long newDepartmentId);

    EmployeeResponseDTO promoteEmployee(Long employeeId, String designation, double salary);
    
    Page<EmployeeResponseDTO> searchByName(String name, Pageable pageable);

    Page<EmployeeResponseDTO> searchByDesignation(String designation, Pageable pageable);
    
    Page<EmployeeResponseDTO> searchByDepartment(
            String department,
            Pageable pageable);

}
