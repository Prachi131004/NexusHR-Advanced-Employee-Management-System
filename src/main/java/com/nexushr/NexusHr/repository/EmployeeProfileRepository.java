package com.nexushr.NexusHr.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nexushr.NexusHr.model.EmployeeProfile;

@Repository
public interface EmployeeProfileRepository extends JpaRepository<EmployeeProfile, Long> {

	Optional<EmployeeProfile> findByEmployee_Id(Long employeeId);
}
