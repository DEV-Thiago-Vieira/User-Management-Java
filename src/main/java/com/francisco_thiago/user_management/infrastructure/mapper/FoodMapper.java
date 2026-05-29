package com.francisco_thiago.user_management.infrastructure.mapper;

import com.francisco_thiago.user_management.infrastructure.dto.FoodRequestDTO;
import com.francisco_thiago.user_management.infrastructure.dto.FoodResponseDTO;
import com.francisco_thiago.user_management.infrastructure.entity.Food;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface FoodMapper {
    Food toEntity(FoodRequestDTO foodRequestDTO);
    FoodResponseDTO toDTO(Food food);
}
