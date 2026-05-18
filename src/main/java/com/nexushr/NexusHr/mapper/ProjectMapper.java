package com.nexushr.NexusHr.mapper;

import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.nexushr.NexusHr.dto.ProjectRequestDTO;
import com.nexushr.NexusHr.dto.ProjectResponseDTO;
import com.nexushr.NexusHr.model.Project;

@Component
public class ProjectMapper {
	
	 private final ModelMapper modelMapper;

	    public ProjectMapper(ModelMapper modelMapper) {
	        this.modelMapper = modelMapper;
	    }

	    // CREATE
	    public Project toEntity(ProjectRequestDTO dto) {
	        return modelMapper.map(dto, Project.class);
	    }

	    // RESPONSE
	    public ProjectResponseDTO toResponseDTO(Project project) {

	        ProjectResponseDTO dto =
	                modelMapper.map(project, ProjectResponseDTO.class);

	        if (project.getEmployees() != null) {

	            dto.setTotalMembers(project.getEmployees().size());

	            Set<String> employeeNames =
	                    project.getEmployees()
	                           .stream()
	                           .map(emp ->
	                               emp.getFirstName() + " " +
	                               emp.getLastName())
	                           .collect(Collectors.toSet());

	            dto.setEmployeeNames(employeeNames);
	        }

	        return dto;
	    }

	    // UPDATE 
	    public void updateEntity(ProjectRequestDTO dto,
	                             Project project) {

	        modelMapper.map(dto, project);
	    }
}
