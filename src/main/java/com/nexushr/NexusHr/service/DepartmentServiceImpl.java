package com.nexushr.NexusHr.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nexushr.NexusHr.dto.DepartmentRequestDTO;
import com.nexushr.NexusHr.dto.DepartmentResponseDTO;
import com.nexushr.NexusHr.enums.DepartmentName;
import com.nexushr.NexusHr.mapper.DepartmentMapper;
import com.nexushr.NexusHr.model.Department;
import com.nexushr.NexusHr.model.Employee;
import com.nexushr.NexusHr.repository.DepartmentRepository;
import com.nexushr.NexusHr.repository.EmployeeRepository;

import jakarta.transaction.Transactional;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	 private final DepartmentRepository departmentRepository;
	    private final EmployeeRepository employeeRepository;
	    private final DepartmentMapper departmentMapper;

	    public DepartmentServiceImpl(DepartmentRepository departmentRepository,
	                                 EmployeeRepository employeeRepository,
	                                 DepartmentMapper departmentMapper) {
	        this.departmentRepository = departmentRepository;
	        this.employeeRepository = employeeRepository;
	        this.departmentMapper = departmentMapper;
	    }

	 // CREATE 
	    
	@Override
	public DepartmentResponseDTO createDepartment(DepartmentRequestDTO dto) {
		
		 Department department = departmentMapper.toEntity(dto);

	        Department saved = departmentRepository.save(department);

	        return departmentMapper.toResponseDTO(saved);
	}

	// GET ALL WITH PAGINATION 
	
	@Override
	public Page<DepartmentResponseDTO> getAllDepartments(Pageable pageable) {
		
		return departmentRepository.findAll(pageable)
                .map(departmentMapper::toResponseDTO);
	}
	
	// GET BY ID 

	@Override
	public DepartmentResponseDTO getDepartmentById(Long id) {
		
		Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found"));

        return departmentMapper.toResponseDTO(department);
	}

	 // UPDATE
	
	@Override
	public DepartmentResponseDTO updateDepartment(Long id, DepartmentRequestDTO dto) {
		
		 Department department = departmentRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Department not found"));

	        departmentMapper.updateEntity(dto, department);

	        Department updated = departmentRepository.save(department);

	        return departmentMapper.toResponseDTO(updated);
	}

	// DELETE / DEACTIVATE 
	
	@Override
	public void deleteDepartment(Long id) {
		 Department department = departmentRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Department not found"));

	        List<Employee> employees =
	                employeeRepository.findByDepartment_Id(id);

	        if (!employees.isEmpty()) {
	            throw new RuntimeException(
	                    "Employees are still assigned to this department");
	        }

	        department.setActive(false);

	        departmentRepository.save(department);
		
	}

	// BULK SALARY RAISE
	
	@Override
	@Transactional
	public void raiseSalaryForDepartment(Long departmentId, double percentage) {
		
		 Department department = departmentRepository.findById(departmentId)
	                .orElseThrow(() -> new RuntimeException("Department not found"));

	        List<Employee> employees = department.getEmployees();

	        for (Employee employee : employees) {

	            double currentSalary = employee.getSalary();

	            double increasedSalary =
	                    currentSalary + (currentSalary * percentage / 100);

	            employee.setSalary(increasedSalary);
	        }
		
	}
	
	 // ANALYTICS 

	@Override
	public DepartmentResponseDTO getDepartmentStats(Long id) {
		
		 Department department = departmentRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Department not found"));

	        return departmentMapper.toResponseDTO(department);
	}

	@Override
	public Page<DepartmentResponseDTO> searchDepartments(
	        DepartmentName departmentName,
	        String location,
	        Pageable pageable) {

	    return departmentRepository
	            .searchDepartments(departmentName, location, pageable)
	            .map(departmentMapper::toResponseDTO);
	}
}
