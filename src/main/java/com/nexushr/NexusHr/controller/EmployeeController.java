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

import com.nexushr.NexusHr.dto.EmployeeRequestDTO;
import com.nexushr.NexusHr.dto.EmployeeResponseDTO;
import com.nexushr.NexusHr.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
	
	 private final EmployeeService employeeService;

	    public EmployeeController(EmployeeService employeeService) {
	        this.employeeService = employeeService;
	    }

	    // ================= CREATE EMPLOYEE =================
	    // POST /api/v1/employees
	    @PostMapping
	    public EmployeeResponseDTO createEmployee(
	            @Valid @RequestBody EmployeeRequestDTO dto) {

	        return employeeService.createEmployee(dto);
	    }

	    // ================= GET ALL EMPLOYEES =================
	    // GET /api/v1/employees
	    @GetMapping
	    public Page<EmployeeResponseDTO> getAllEmployees(
	            Pageable pageable) {

	        return employeeService.getAllEmployees(pageable);
	    }
	    
	    // ================= GET EMPLOYEE BY ID =================
	    // GET /api/v1/employees/{id}
	    @GetMapping("/{id}")
	    public EmployeeResponseDTO getEmployeeById(
	            @PathVariable Long id) {

	        return employeeService.getEmployeeById(id);
	    }

	    // ================= UPDATE EMPLOYEE =================
	    // PUT /api/v1/employees/{id}
	    @PutMapping("/{id}")
	    public EmployeeResponseDTO updateEmployee(
	            @PathVariable Long id,
	            @Valid @RequestBody EmployeeRequestDTO dto) {

	        return employeeService.updateEmployee(id, dto);
	    }
	    
	 // ================= DELETE / RESIGN EMPLOYEE =================
	    // DELETE /api/v1/employees/{id}
	    @DeleteMapping("/{id}")
	    public String deleteEmployee(
	            @PathVariable Long id) {

	        employeeService.deleteEmployee(id);
	        return "Employee deactivated successfully";
	    }

	    // ================= TRANSFER EMPLOYEE =================
	    // PUT /api/v1/employees/{id}/transfer?departmentId=2
	    @PutMapping("/{id}/transfer")
	    public EmployeeResponseDTO transferEmployee(
	            @PathVariable Long id,
	            @RequestParam Long departmentId) {

	        return employeeService.transferEmployee(id, departmentId);
	    }
	    
	 // ================= PROMOTION =================
	    // PUT /api/v1/employees/{id}/promotion?designation=Manager&salary=90000
	    @PutMapping("/{id}/promotion")
	    public EmployeeResponseDTO promoteEmployee(
	            @PathVariable Long id,
	            @RequestParam String designation,
	            @RequestParam double salary) {

	        return employeeService.promoteEmployee(id, designation, salary);
	    }

	    @GetMapping("/search/name")
	    public Page<EmployeeResponseDTO> searchByName(
	            @RequestParam String name,
	            Pageable pageable) {

	        return employeeService.searchByName(name, pageable);
	    }
	    
	    @GetMapping("/search/department")
	    public Page<EmployeeResponseDTO> searchByDepartment(
	            @RequestParam String department,
	            Pageable pageable) {

	        return employeeService.searchByDepartment(
	                department,
	                pageable);
	    }

	    @GetMapping("/search/designation")
	    public Page<EmployeeResponseDTO> searchByDesignation(
	            @RequestParam String designation,
	            Pageable pageable) {

	        return employeeService.searchByDesignation(
	                designation,
	                pageable);
	    }
}
