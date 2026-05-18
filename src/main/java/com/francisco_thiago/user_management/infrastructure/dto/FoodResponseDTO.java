package com.francisco_thiago.user_management.infrastructure.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record FoodResponseDTO(
		@Schema(description = "Food ID", example = "2")
		Long id,
		@Schema(description = "Food name", example = "Burger")
		String name,
		@Schema(description = "Food price", example = "19.99")
		Double price
) {
}
