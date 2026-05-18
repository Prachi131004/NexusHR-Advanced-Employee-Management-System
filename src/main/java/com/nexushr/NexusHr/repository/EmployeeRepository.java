package com.nexushr.NexusHr.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nexushr.NexusHr.enums.DepartmentName;
import com.nexushr.NexusHr.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	 List<Employee> findByDepartment_Id(Long departmentId);


	    Page<Employee> findByFirstNameContainingIgnoreCase(
	            String firstName,
	            Pageable pageable);

	    Page<Employee> findByDepartment_DepartmentName(
	            DepartmentName department,
	            Pageable pageable);

	    Page<Employee> findByDesignationContainingIgnoreCase(
	            String designation,
	            Pageable pageable);
}
