package com.francisco_thiago.user_management.infrastructure.mapper;

import com.francisco_thiago.user_management.infrastructure.dto.DetailedUserResponseDTO;
import com.francisco_thiago.user_management.infrastructure.dto.UserRequestDTO;
import com.francisco_thiago.user_management.infrastructure.dto.UserResponseDTO;
import com.francisco_thiago.user_management.infrastructure.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    User toEntity(UserRequestDTO userRequestDTO);
    UserResponseDTO toDTO(User user);
    DetailedUserResponseDTO toDetailedDTO(User user);
}
