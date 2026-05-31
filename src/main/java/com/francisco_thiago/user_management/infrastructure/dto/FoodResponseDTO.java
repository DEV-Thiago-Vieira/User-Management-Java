package com.francisco_thiago.user_management.infrastructure.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.util.UUID;

public record FoodResponseDTO(
		@Schema(description = "Food ID", example = "550e8400-e29b-41d4-a716-446655440001")
		UUID id,
		@Schema(description = "Food name", example = "Burger")
		String name,
		@Schema(description = "Food price", example = "19.99")
		BigDecimal price
) {
}
