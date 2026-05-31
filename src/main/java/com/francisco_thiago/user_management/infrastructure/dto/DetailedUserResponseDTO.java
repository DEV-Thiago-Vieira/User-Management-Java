package com.francisco_thiago.user_management.infrastructure.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

public record DetailedUserResponseDTO(
        @Schema(description = "User ID", example = "550e8400-e29b-41d4-a716-446655440000")
        UUID id,
        @Schema(description = "User name", example = "John Doe")
        String name,
        @Schema(description = "User email", example = "email@email.com")
        String email
) {
}
