package com.nexushr.NexusHr.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nexushr.NexusHr.dto.ProjectRequestDTO;
import com.nexushr.NexusHr.dto.ProjectResponseDTO;
import com.nexushr.NexusHr.service.ProjectService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/projects")
public class ProjectController {
	
	private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    // ================= CREATE PROJECT =================
    // POST /api/v1/projects
    @PostMapping
    public ProjectResponseDTO createProject(
            @Valid @RequestBody ProjectRequestDTO dto) {

        return projectService.createProject(dto);
    }

    // ================= GET ALL PROJECTS =================
    // GET /api/v1/projects
    @GetMapping
    public Page<ProjectResponseDTO> getAllProjects(
            Pageable pageable) {

        return projectService.getAllProjects(pageable);
    }

    // ================= GET PROJECT BY ID =================
    // GET /api/v1/projects/{id}
    @GetMapping("/{id}")
    public ProjectResponseDTO getProjectById(
            @PathVariable Long id) {

        return projectService.getProjectById(id);
    }

    // ================= UPDATE PROJECT =================
    // PUT /api/v1/projects/{id}
    @PutMapping("/{id}")
    public ProjectResponseDTO updateProject(
            @PathVariable Long id,
            @Valid @RequestBody ProjectRequestDTO dto) {

        return projectService.updateProject(id, dto);
    }

    // ================= DELETE PROJECT =================
    // DELETE /api/v1/projects/{id}
    @DeleteMapping("/{id}")
    public String deleteProject(
            @PathVariable Long id) {

        projectService.deleteProject(id);
        return "Project deleted successfully";
    }

    // ================= ASSIGN EMPLOYEES =================
    // POST /api/v1/projects/{projectId}/assign
    @PostMapping("/{projectId}/assign")
    public ProjectResponseDTO assignEmployees(
            @PathVariable Long projectId,
            @RequestBody List<Long> employeeIds) {

        return projectService.assignEmployees(projectId, employeeIds);
    }

    // ================= REMOVE EMPLOYEE =================
    // DELETE /api/v1/projects/{projectId}/employees/{employeeId}
    @DeleteMapping("/{projectId}/employees/{employeeId}")
    public ProjectResponseDTO removeEmployee(
            @PathVariable Long projectId,
            @PathVariable Long employeeId) {

        return projectService.removeEmployee(projectId, employeeId);
    }

    // ================= VIEW PROJECT MEMBERS =================
    // GET /api/v1/projects/{id}/members
    @GetMapping("/{id}/members")
    public List<String> getProjectMembers(
            @PathVariable Long id) {

        return projectService.getProjectMembers(id);
    }

    // ================= PROJECT TIMELINE / BACKLOG =================
    // GET /api/v1/projects/{id}/backlog
    @GetMapping("/{id}/backlog")
    public ProjectResponseDTO getProjectTimeline(
            @PathVariable Long id) {

        return projectService.getProjectTimeline(id);
    }
    
    @GetMapping("/search")
    public Page<ProjectResponseDTO> searchProjects(
            @RequestParam(required = false) String projectName,
            @RequestParam(required = false) String clientName,
            Pageable pageable) {

        return projectService.searchProjects(
                projectName,
                clientName,
                pageable);
    }
}

