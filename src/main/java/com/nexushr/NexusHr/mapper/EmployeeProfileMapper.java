package com.nexushr.NexusHr.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.nexushr.NexusHr.dto.EmployeeProfileRequestDTO;
import com.nexushr.NexusHr.dto.EmployeeProfileResponseDTO;
import com.nexushr.NexusHr.model.EmployeeProfile;

@Component
public class EmployeeProfileMapper {

	private final ModelMapper modelMapper;

    public EmployeeProfileMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    // CREATE 
    public EmployeeProfile toEntity(EmployeeProfileRequestDTO dto) {
        return modelMapper.map(dto, EmployeeProfile.class);
    }

    // RESPONSE
    public EmployeeProfileResponseDTO toResponseDTO(
            EmployeeProfile profile) {

        EmployeeProfileResponseDTO dto =
                modelMapper.map(profile,
                EmployeeProfileResponseDTO.class);

        if (profile.getEmployee() != null) {
            dto.setEmployeeId(
                    profile.getEmployee().getId());
        }

        return dto;
    }

    // UPDATE
    public void updateEntity(EmployeeProfileRequestDTO dto,
                             EmployeeProfile profile) {

        modelMapper.map(dto, profile);
    }
}
