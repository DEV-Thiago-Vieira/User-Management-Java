package com.francisco_thiago.user_management.infrastructure.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record UserRequestDTO(
        @Schema(description = "User name", example = "John Doe")
        String name,
        @Schema(description = "User email", example = "email@email.com")
        String email,
        @Schema(description = "User password", example = "*****")
        String password
) {
}
