package com.nexushr.NexusHr.service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nexushr.NexusHr.dto.EmployeeRequestDTO;
import com.nexushr.NexusHr.dto.EmployeeResponseDTO;
import com.nexushr.NexusHr.enums.DepartmentName;
import com.nexushr.NexusHr.enums.EmployeeStatus;
import com.nexushr.NexusHr.mapper.EmployeeMapper;
import com.nexushr.NexusHr.model.Department;
import com.nexushr.NexusHr.model.Employee;
import com.nexushr.NexusHr.model.Project;
import com.nexushr.NexusHr.repository.DepartmentRepository;
import com.nexushr.NexusHr.repository.EmployeeRepository;
import com.nexushr.NexusHr.repository.ProjectRepository;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private final ProjectRepository projectRepository;
    private final EmployeeMapper employeeMapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository,
                               DepartmentRepository departmentRepository,
                               ProjectRepository projectRepository,
                               EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
        this.projectRepository = projectRepository;
        this.employeeMapper = employeeMapper;
    }

    // CREATE 
    
	@Override
	public EmployeeResponseDTO createEmployee(EmployeeRequestDTO dto) {
		
		
		Employee employee = employeeMapper.toEntity(dto);
		employee.setId(null);  
		
		Department department = departmentRepository.findById(dto.getDepartmentId())
                .orElseThrow(() -> new RuntimeException("Department not found"));

        employee.setDepartment(department);
        
        if (dto.getProjectIds() != null && !dto.getProjectIds().isEmpty()) {

            Set<Project> projects = dto.getProjectIds()
                    .stream()
                    .map(id -> projectRepository.findById(id)
                            .orElseThrow(() -> new RuntimeException("Project not found: " + id)))
                    .collect(Collectors.toSet());

            employee.setProjects(projects);
        }
        
        Employee saved = employeeRepository.save(employee);

        return employeeMapper.toResponseDTO(saved);
	}
	
	// GET BY ID 

	@Override
	public EmployeeResponseDTO getEmployeeById(Long id) {
		
	    
	        Employee employee = employeeRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Employee not found"));

	        return employeeMapper.toResponseDTO(employee);
	    }

	 // GET ALL 
	
	@Override
	public List<EmployeeResponseDTO> getAllEmployees() {
		 return employeeRepository.findAll()
	                .stream()
	                .map(employeeMapper::toResponseDTO)
	                .collect(Collectors.toList());
	}
	
	 // PAGINATION 

	@Override
	public Page<EmployeeResponseDTO> getAllEmployees(Pageable pageable) {
		return employeeRepository.findAll(pageable)
                .map(employeeMapper::toResponseDTO);
	}
	
	// UPDATE 

	@Override
	public EmployeeResponseDTO updateEmployee(Long id, EmployeeRequestDTO dto) {
		Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        employeeMapper.updateEntity(dto, employee);

        Department department = departmentRepository.findById(dto.getDepartmentId())
                .orElseThrow(() -> new RuntimeException("Department not found"));

        employee.setDepartment(department);

        if (dto.getProjectIds() != null) {

            Set<Project> projects = new HashSet<>();

            for (Long pid : dto.getProjectIds()) {

                Project project = projectRepository.findById(pid)
                        .orElseThrow(() -> new RuntimeException("Project not found"));

                projects.add(project);
            }

            employee.setProjects(projects);
        }
        
        Employee updated = employeeRepository.save(employee);

        return employeeMapper.toResponseDTO(updated);
	}

	// DELETE
	@Override
	public void deleteEmployee(Long id) {
		 Employee employee = employeeRepository.findById(id)
			        .orElseThrow(() -> new RuntimeException("Employee not found"));

		 employee.setActive(false);
		 employee.setStatus(EmployeeStatus.RESIGNED);
		 employee.setExitDate(LocalDate.now());

			    employeeRepository.save(employee);
		
	}
	
	// TRANSFER 
	@Override
	@Transactional
	public EmployeeResponseDTO transferEmployee(Long employeeId, Long newDepartmentId) {
		
		 Employee employee = employeeRepository.findById(employeeId)
	                .orElseThrow(() -> new RuntimeException("Employee not found"));

	        Department department = departmentRepository.findById(newDepartmentId)
	                .orElseThrow(() -> new RuntimeException("Department not found"));

	        employee.setDepartment(department);

	        return employeeMapper.toResponseDTO(employee);
	}
	
	 // PROMOTION 
	@Override
	@Transactional
	public EmployeeResponseDTO promoteEmployee(Long employeeId, String designation, double salary) {
		
		Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        employee.setDesignation(designation);
        employee.setSalary(salary);

        return employeeMapper.toResponseDTO(employee);
	}

	@Override
	public Page<EmployeeResponseDTO> searchByDepartment(
	        String department,
	        Pageable pageable) {

	    DepartmentName deptEnum =
	            DepartmentName.valueOf(department.toUpperCase());

	    return employeeRepository
	            .findByDepartment_DepartmentName(deptEnum, pageable)
	            .map(employeeMapper::toResponseDTO);
	}

	@Override
	public Page<EmployeeResponseDTO> searchByName(String name, Pageable pageable) {
		return employeeRepository
	            .findByFirstNameContainingIgnoreCase(name, pageable)
	            .map(employeeMapper::toResponseDTO);
	}

	@Override
	public Page<EmployeeResponseDTO> searchByDesignation(String designation, Pageable pageable) {
		 return employeeRepository
		            .findByDesignationContainingIgnoreCase(designation, pageable)
		            .map(employeeMapper::toResponseDTO);
	}


}
