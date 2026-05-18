package com.nexushr.NexusHr.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.nexushr.NexusHr.dto.LeaveRequestDTO;
import com.nexushr.NexusHr.dto.LeaveResponseDTO;
import com.nexushr.NexusHr.model.LeaveRequests;

@Component
public class LeaveRequestMapper {
	
	private final ModelMapper modelMapper;

    public LeaveRequestMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    // REQUEST -> ENTITY 
    public LeaveRequests toEntity(LeaveRequestDTO dto) {
        return modelMapper.map(dto, LeaveRequests.class);
    }

    // ENTITY -> RESPONSE 
    public LeaveResponseDTO toResponseDTO(LeaveRequests leave) {

    	 LeaveResponseDTO dto =
    	            modelMapper.map(leave, LeaveResponseDTO.class);

    	    if (leave.getEmployee() != null) {
    	        dto.setEmployeeId(leave.getEmployee().getId());
    	    }

    	    return dto;
    }

    // UPDATE ENTITY 
    public void updateEntity(LeaveRequestDTO dto,
                             LeaveRequests leave) {

        modelMapper.map(dto, leave);
    }

}
