package com.nexushr.NexusHr.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nexushr.NexusHr.dto.ProjectRequestDTO;
import com.nexushr.NexusHr.dto.ProjectResponseDTO;

public interface ProjectService {
	
	ProjectResponseDTO createProject(ProjectRequestDTO dto);

    List<ProjectResponseDTO> getAllProjects();

    ProjectResponseDTO getProjectById(Long id);

    ProjectResponseDTO updateProject(Long id, ProjectRequestDTO dto);

    void deleteProject(Long id);
    
    Page<ProjectResponseDTO> getAllProjects(Pageable pageable);

    ProjectResponseDTO assignEmployees(Long projectId, List<Long> employeeIds);

    ProjectResponseDTO removeEmployee(Long projectId, Long employeeId);

    List<String> getProjectMembers(Long projectId);

    ProjectResponseDTO getProjectTimeline(Long projectId);
    
    Page<ProjectResponseDTO> searchProjects(
            String projectName,
            String clientName,
            Pageable pageable);

}
