package com.francisco_thiago.user_management.infrastructure.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record DetailedUserResponseDTO(
        @Schema(description = "User ID", example = "1")
        Long id,
        @Schema(description = "User name", example = "John Doe")
        String name,
        @Schema(description = "User email", example = "email@email.com")
        String email
) {
}
