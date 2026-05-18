package com.nexushr.NexusHr.mapper;

import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.nexushr.NexusHr.dto.EmployeeRequestDTO;
import com.nexushr.NexusHr.dto.EmployeeResponseDTO;
import com.nexushr.NexusHr.model.Employee;
import com.nexushr.NexusHr.model.Project;

@Component
public class EmployeeMapper {

	
	private final ModelMapper modelMapper;
	 
    public EmployeeMapper(ModelMapper modelMapper) {
		super();
		this.modelMapper = modelMapper;
	}

	// Entity -> ResponseDTO
    public EmployeeResponseDTO toResponseDTO(Employee employee) {
        EmployeeResponseDTO dto = modelMapper.map(employee, EmployeeResponseDTO.class);
 
        // Department handling
        if (employee.getDepartment() != null) {
            dto.setDepartmentName(employee.getDepartment().getDepartmentName().name());
        }
 
        if (employee.getProjects() != null) {
            Set<String> projectNames = employee.getProjects().stream()
                    .map(Project::getProjectName)
                    .collect(Collectors.toSet());
            dto.setProjectNames(projectNames);
        }
 
        return dto;
    }
 
    // RequestDTO -> Entity
    public Employee toEntity(EmployeeRequestDTO dto) {
        return modelMapper.map(dto, Employee.class);
    }

	public void updateEntity(EmployeeRequestDTO dto, Employee employee) {
		 modelMapper.map(dto, employee);		
	}


 
 
 
}
