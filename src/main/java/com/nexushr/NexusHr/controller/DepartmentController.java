package com.nexushr.NexusHr.controller;

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

import com.nexushr.NexusHr.dto.DepartmentRequestDTO;
import com.nexushr.NexusHr.dto.DepartmentResponseDTO;
import com.nexushr.NexusHr.enums.DepartmentName;
import com.nexushr.NexusHr.service.DepartmentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/departments")
public class DepartmentController {
	
	private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    // ================= CREATE DEPARTMENT =================
    // POST /api/v1/departments
    @PostMapping
    public DepartmentResponseDTO createDepartment(
            @Valid @RequestBody DepartmentRequestDTO dto) {

        return departmentService.createDepartment(dto);
    }
    
 // ================= GET ALL WITH PAGINATION =================
    // GET /api/v1/departments
    @GetMapping
    public Page<DepartmentResponseDTO> getAllDepartments(
            Pageable pageable) {

        return departmentService.getAllDepartments(pageable);
    }

    // ================= GET BY ID =================
    // GET /api/v1/departments/{id}
    @GetMapping("/{id}")
    public DepartmentResponseDTO getDepartmentById(
            @PathVariable Long id) {

        return departmentService.getDepartmentById(id);
    }

 // ================= UPDATE =================
    // PUT /api/v1/departments/{id}
    @PutMapping("/{id}")
    public DepartmentResponseDTO updateDepartment(
            @PathVariable Long id,
            @Valid @RequestBody DepartmentRequestDTO dto) {

        return departmentService.updateDepartment(id, dto);
    }

    // ================= DELETE / DEACTIVATE =================
    // DELETE /api/v1/departments/{id}
    @DeleteMapping("/{id}")
    public String deleteDepartment(
            @PathVariable Long id) {

        departmentService.deleteDepartment(id);
        return "Department deactivated successfully";
    }
    
 // ================= BULK SALARY RAISE =================
    // PUT /api/v1/departments/{id}/raise?percentage=10
    @PutMapping("/{id}/raise")
    public String raiseSalary(
            @PathVariable Long id,
            @RequestParam double percentage) {

        departmentService.raiseSalaryForDepartment(id, percentage);
        return "Salary updated successfully";
    }

    // ================= ANALYTICS =================
    // GET /api/v1/departments/{id}/stats
    @GetMapping("/{id}/stats")
    public DepartmentResponseDTO getDepartmentStats(
            @PathVariable Long id) {

        return departmentService.getDepartmentStats(id);
    }

    @GetMapping("/search")
    public Page<DepartmentResponseDTO> searchDepartments(
            @RequestParam(required = false) DepartmentName departmentName,
            @RequestParam(required = false) String location,
            Pageable pageable) {

        return departmentService.searchDepartments(
                departmentName,
                location,
                pageable
        );
    }
}
