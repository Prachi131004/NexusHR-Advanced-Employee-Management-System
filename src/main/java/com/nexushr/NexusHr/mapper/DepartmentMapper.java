package com.nexushr.NexusHr.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.nexushr.NexusHr.dto.DepartmentRequestDTO;
import com.nexushr.NexusHr.dto.DepartmentResponseDTO;
import com.nexushr.NexusHr.model.Department;

@Component
public class DepartmentMapper {
	
	public DepartmentMapper(ModelMapper modelMapper) {
		super();
		this.modelMapper = modelMapper;
	}

	private final ModelMapper modelMapper;
	 
    public DepartmentResponseDTO toResponseDTO(Department department) {
        DepartmentResponseDTO dto = modelMapper.map(department, DepartmentResponseDTO.class);
        if (department.getEmployees() != null) {
            dto.setTotalEmployees(department.getEmployees().size());
        }
        return dto;
    }
 
    public Department toEntity(DepartmentRequestDTO dto) {
        return modelMapper.map(dto, Department.class);
    }

	public void updateEntity(DepartmentRequestDTO dto, Department department) {
		 modelMapper.map(dto, department);
		
	}
}
