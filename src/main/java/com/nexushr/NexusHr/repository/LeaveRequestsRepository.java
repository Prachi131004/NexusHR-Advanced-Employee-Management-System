package com.nexushr.NexusHr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nexushr.NexusHr.model.LeaveRequests;

@Repository
public interface LeaveRequestsRepository extends JpaRepository<LeaveRequests, Long> {

	List<LeaveRequests> findByEmployee_Id(Long employeeId);

}
