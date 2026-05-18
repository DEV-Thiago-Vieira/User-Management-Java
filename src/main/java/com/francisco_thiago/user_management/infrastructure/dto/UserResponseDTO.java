package com.francisco_thiago.user_management.infrastructure.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record UserResponseDTO(
		@Schema(description = "User ID", example = "1")
		Long id,
		@Schema(description = "User name", example = "John Doe")
		String name
) {
}
