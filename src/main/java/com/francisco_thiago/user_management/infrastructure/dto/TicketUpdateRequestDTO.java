package com.francisco_thiago.user_management.infrastructure.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

public record TicketUpdateRequestDTO(
		@Schema(description = "Ticket ID", example = "550e8400-e29b-41d4-a716-446655440002", requiredMode = Schema.RequiredMode.REQUIRED)
		UUID id,
		@Schema(description = "New user ID linked to the ticket", example = "550e8400-e29b-41d4-a716-446655440000")
		UUID userId,
		@Schema(description = "New food ID linked to the ticket", example = "550e8400-e29b-41d4-a716-446655440001")
		UUID foodId
) {
}
