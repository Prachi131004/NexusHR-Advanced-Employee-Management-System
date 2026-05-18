package com.nexushr.NexusHr.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexushr.NexusHr.dto.EmployeeProfileRequestDTO;
import com.nexushr.NexusHr.dto.EmployeeProfileResponseDTO;
import com.nexushr.NexusHr.service.EmployeeProfileService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/profiles")
public class EmployeeProfileController {
	
	private final EmployeeProfileService employeeProfileService;

    public EmployeeProfileController(
            EmployeeProfileService employeeProfileService) {
        this.employeeProfileService = employeeProfileService;
    }

    // ================= CREATE PROFILE =================
    // POST /api/v1/profiles
    @PostMapping
    public EmployeeProfileResponseDTO createProfile(
            @Valid @RequestBody EmployeeProfileRequestDTO dto) {

        return employeeProfileService.createProfile(dto);
    }

    // ================= GET PROFILE BY EMPLOYEE ID =================
    // GET /api/v1/profiles/{employeeId}
    @GetMapping("/{employeeId}")
    public EmployeeProfileResponseDTO getProfileByEmployeeId(
            @PathVariable Long employeeId) {

        return employeeProfileService
                .getProfileByEmployeeId(employeeId);
    }

    // ================= UPDATE PROFILE =================
    // PUT /api/v1/profiles/{employeeId}
    @PutMapping("/{employeeId}")
    public EmployeeProfileResponseDTO updateProfile(
            @PathVariable Long employeeId,
            @Valid @RequestBody EmployeeProfileRequestDTO dto) {

        return employeeProfileService
                .updateProfile(employeeId, dto);
    }

    // ================= DELETE PROFILE =================
    // DELETE /api/v1/profiles/{employeeId}
    @DeleteMapping("/{employeeId}")
    public String deleteProfile(
            @PathVariable Long employeeId) {

        employeeProfileService.deleteProfile(employeeId);
        return "Profile deleted successfully";
    }
	

}
