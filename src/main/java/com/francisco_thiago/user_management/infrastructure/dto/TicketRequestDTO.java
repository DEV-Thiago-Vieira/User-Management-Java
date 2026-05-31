package com.francisco_thiago.user_management.infrastructure.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

public record TicketRequestDTO(
		@Schema(description = "ID of the user linked to the ticket", example = "550e8400-e29b-41d4-a716-446655440000", requiredMode = Schema.RequiredMode.REQUIRED)
		UUID userId,
		@Schema(description = "ID of the food linked to the ticket", example = "550e8400-e29b-41d4-a716-446655440001", requiredMode = Schema.RequiredMode.REQUIRED)
		UUID foodId
) {
}
