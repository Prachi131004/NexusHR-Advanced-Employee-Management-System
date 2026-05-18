package com.nexushr.NexusHr.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nexushr.NexusHr.enums.DepartmentName;
import com.nexushr.NexusHr.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{
	
	@Query("""
	        SELECT d FROM Department d
	        WHERE (:departmentName IS NULL OR d.departmentName = :departmentName)
	        AND (:location IS NULL OR LOWER(d.location) LIKE LOWER(CONCAT('%', :location, '%')))
	    """)
	    Page<Department> searchDepartments(
	            @Param("departmentName") DepartmentName departmentName,
	            @Param("location") String location,
	            Pageable pageable
	    );

}
