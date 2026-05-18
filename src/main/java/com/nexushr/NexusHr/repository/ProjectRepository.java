package com.nexushr.NexusHr.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nexushr.NexusHr.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>{
	
	Page<Project> findByProjectNameContainingIgnoreCase(
            String projectName,
            Pageable pageable);

    Page<Project> findByClientNameContainingIgnoreCase(
            String clientName,
            Pageable pageable);

    Page<Project> findByProjectNameContainingIgnoreCaseAndClientNameContainingIgnoreCase(
            String projectName,
            String clientName,
            Pageable pageable);

}
