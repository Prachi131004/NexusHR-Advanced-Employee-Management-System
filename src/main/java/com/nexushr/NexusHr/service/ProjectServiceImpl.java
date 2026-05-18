package com.nexushr.NexusHr.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nexushr.NexusHr.dto.ProjectRequestDTO;
import com.nexushr.NexusHr.dto.ProjectResponseDTO;
import com.nexushr.NexusHr.mapper.ProjectMapper;
import com.nexushr.NexusHr.model.Employee;
import com.nexushr.NexusHr.model.Project;
import com.nexushr.NexusHr.repository.EmployeeRepository;
import com.nexushr.NexusHr.repository.ProjectRepository;

import jakarta.transaction.Transactional;

@Service
public class ProjectServiceImpl implements ProjectService{

	 private final ProjectRepository projectRepository;
	    private final EmployeeRepository employeeRepository;
	    private final ProjectMapper projectMapper;

	    public ProjectServiceImpl(ProjectRepository projectRepository,
	                              EmployeeRepository employeeRepository,
	                              ProjectMapper projectMapper) {
	        this.projectRepository = projectRepository;
	        this.employeeRepository = employeeRepository;
	        this.projectMapper = projectMapper;
	    }
	    
	    //CREATE PROJECT 
	    
	@Override
	public ProjectResponseDTO createProject(ProjectRequestDTO dto) {
		
		Project project = projectMapper.toEntity(dto);
        Project saved = projectRepository.save(project);

        return projectMapper.toResponseDTO(saved);
	}

	//GET ALL 
	
	@Override
	public List<ProjectResponseDTO> getAllProjects() {
		 return projectRepository.findAll()
	                .stream()
	                .map(projectMapper::toResponseDTO)
	                .collect(Collectors.toList());
	}

	//GET BY ID
	
	@Override
	public ProjectResponseDTO getProjectById(Long id) {
		 Project project = projectRepository.findById(id)
	                .orElseThrow(() ->
	                        new RuntimeException("Project not found"));

	        return projectMapper.toResponseDTO(project);
	}

	//UPDATE
	@Override
	public ProjectResponseDTO updateProject(Long id, ProjectRequestDTO dto) {
		 Project project = projectRepository.findById(id)
	                .orElseThrow(() ->
	                        new RuntimeException("Project not found"));

	        projectMapper.updateEntity(dto, project);

	        Project updated = projectRepository.save(project);

	        return projectMapper.toResponseDTO(updated);
	}
	
	//DELETE/DEACTIVE

	@Override
	public void deleteProject(Long id) {
		Project project = projectRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Project not found"));

        projectRepository.delete(project);
		
	}
	
	//ASSIGN EMPLOYEES

	@Override
	@Transactional
	public ProjectResponseDTO assignEmployees(Long projectId, List<Long> employeeIds) {
		 Project project = projectRepository.findById(projectId)
	                .orElseThrow(() ->
	                        new RuntimeException("Project not found"));

	        Set<Employee> employees = new HashSet<>();

	        for (Long empId : employeeIds) {

	            Employee employee =
	                    employeeRepository.findById(empId)
	                    .orElseThrow(() ->
	                        new RuntimeException(
	                            "Employee not found: " + empId));

	            employees.add(employee);
	        }

	        project.setEmployees(employees);

	        return projectMapper.toResponseDTO(project);
	}

	//REMOVE EMPLOYEES
	
	@Override
	@Transactional
	public ProjectResponseDTO removeEmployee(Long projectId, Long employeeId) {
		Project project = projectRepository.findById(projectId)
                .orElseThrow(() ->
                        new RuntimeException("Project not found"));

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new RuntimeException("Employee not found"));

        project.getEmployees().remove(employee);

        return projectMapper.toResponseDTO(project);
	}

	//VIEW MEMBERS 
	
	@Override
	public List<String> getProjectMembers(Long projectId) {
		Project project = projectRepository.findById(projectId)
                .orElseThrow(() ->
                        new RuntimeException("Project not found"));

        return project.getEmployees()
                .stream()
                .map(emp ->
                        emp.getFirstName() + " " +
                        emp.getLastName())
                .collect(Collectors.toList());
	}

	// PROJECT BACKLOG / TIMELINE
	
	@Override
	public ProjectResponseDTO getProjectTimeline(Long projectId) {
		Project project = projectRepository.findById(projectId)
                .orElseThrow(() ->
                        new RuntimeException("Project not found"));

        return projectMapper.toResponseDTO(project);
	}

	//PAGINATION
	@Override
	public Page<ProjectResponseDTO> getAllProjects(Pageable pageable) {
		return projectRepository.findAll(pageable)
	            .map(projectMapper::toResponseDTO);
	}
	
	@Override
	public Page<ProjectResponseDTO> searchProjects(
	        String projectName,
	        String clientName,
	        Pageable pageable) {

	    if (projectName != null && clientName != null) {

	        return projectRepository
	                .findByProjectNameContainingIgnoreCaseAndClientNameContainingIgnoreCase(
	                        projectName,
	                        clientName,
	                        pageable)
	                .map(projectMapper::toResponseDTO);
	    }

	    if (projectName != null) {

	        return projectRepository
	                .findByProjectNameContainingIgnoreCase(
	                        projectName,
	                        pageable)
	                .map(projectMapper::toResponseDTO);
	    }

	    if (clientName != null) {

	        return projectRepository
	                .findByClientNameContainingIgnoreCase(
	                        clientName,
	                        pageable)
	                .map(projectMapper::toResponseDTO);
	    }

	    return projectRepository.findAll(pageable)
	            .map(projectMapper::toResponseDTO);
	}

}
